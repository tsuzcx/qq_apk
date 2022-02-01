package com.tencent.mm.ui;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;

public abstract class FragmentActivitySupport
  extends Fragment
{
  private byte _hellAccFlag_;
  public boolean hasDestory = false;
  public boolean isCurrentActivity;
  private FragmentActivity mActivity;
  
  public FragmentActivitySupport()
  {
    this.isCurrentActivity = false;
  }
  
  public FragmentActivitySupport(boolean paramBoolean)
  {
    this.isCurrentActivity = paramBoolean;
  }
  
  public View findViewById(int paramInt)
  {
    View localView2 = getView();
    View localView1 = null;
    if (localView2 != null) {
      localView1 = localView2.findViewById(paramInt);
    }
    if (localView1 != null) {
      return localView1;
    }
    return thisActivity().findViewById(paramInt);
  }
  
  public void finish()
  {
    if (this.isCurrentActivity) {
      if (thisActivity() != null) {
        thisActivity().finish();
      }
    }
    while (thisActivity() == null) {
      return;
    }
    thisActivity().getSupportFragmentManager().popBackStack();
  }
  
  public LayoutInflater getActivityLayoutInflater()
  {
    return thisActivity().getLayoutInflater();
  }
  
  public Boolean getBooleanExtra(String paramString, boolean paramBoolean)
  {
    if ((this.isCurrentActivity) && (getArguments() == null)) {
      return Boolean.valueOf(thisActivity().getIntent().getBooleanExtra(paramString, paramBoolean));
    }
    return Boolean.valueOf(getArguments().getBoolean(paramString, paramBoolean));
  }
  
  public ContentResolver getContentResolver()
  {
    if (thisActivity() != null) {
      return thisActivity().getContentResolver();
    }
    return null;
  }
  
  public int getIntExtra(String paramString, int paramInt)
  {
    int i;
    if ((this.isCurrentActivity) && (getArguments() == null) && (thisActivity() != null)) {
      i = thisActivity().getIntent().getIntExtra(paramString, paramInt);
    }
    do
    {
      return i;
      i = paramInt;
    } while (getArguments() == null);
    return getArguments().getInt(paramString, paramInt);
  }
  
  public long getLongExtra(String paramString, long paramLong)
  {
    long l;
    if ((this.isCurrentActivity) && (getArguments() == null)) {
      l = thisActivity().getIntent().getLongExtra(paramString, paramLong);
    }
    do
    {
      return l;
      l = paramLong;
    } while (getArguments() == null);
    return getArguments().getLong(paramString, paramLong);
  }
  
  public String getPackageName()
  {
    return thisActivity().getPackageName();
  }
  
  public <T extends Parcelable> T getParcelableExtra(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.isCurrentActivity)
    {
      localObject1 = localObject2;
      if (thisActivity() != null) {
        localObject1 = thisActivity().getIntent().getParcelableExtra(paramString);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (getArguments() != null) {
        localObject2 = super.getArguments().getParcelable(paramString);
      }
    }
    return localObject2;
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return thisActivity().getSharedPreferences(paramString, paramInt);
  }
  
  public ArrayList<String> getStringArrayList(String paramString)
  {
    if ((this.isCurrentActivity) && (getArguments() == null)) {
      return thisActivity().getIntent().getStringArrayListExtra(paramString);
    }
    return getArguments().getStringArrayList(paramString);
  }
  
  public String getStringExtra(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.isCurrentActivity)
    {
      localObject1 = localObject2;
      if (thisActivity() != null) {
        localObject1 = thisActivity().getIntent().getStringExtra(paramString);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (getArguments() != null) {
        localObject2 = super.getArguments().getString(paramString);
      }
    }
    return localObject2;
  }
  
  public Window getWindow()
  {
    if (thisActivity() != null) {
      return thisActivity().getWindow();
    }
    return null;
  }
  
  public WindowManager getWindowManager()
  {
    if (thisActivity() != null) {
      return thisActivity().getWindowManager();
    }
    return null;
  }
  
  public boolean isFinishing()
  {
    if (thisActivity() == null) {
      return true;
    }
    return thisActivity().isFinishing();
  }
  
  public boolean isShowing()
  {
    return !this.hasDestory;
  }
  
  public final Cursor managedQuery(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (thisActivity() != null) {
      return thisActivity().managedQuery(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    }
    return null;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mActivity = getActivity();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.hasDestory = true;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      finish();
      return true;
    }
    if ((paramInt == 82) && (paramKeyEvent.getAction() == 1)) {
      return onKeyUp(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void openContextMenu(View paramView)
  {
    if (thisActivity() != null) {
      thisActivity().openContextMenu(paramView);
    }
  }
  
  public void overridePendingTransition(int paramInt1, int paramInt2)
  {
    if (thisActivity() != null) {
      thisActivity().overridePendingTransition(paramInt1, paramInt2);
    }
  }
  
  public void sendBroadcast(Intent paramIntent)
  {
    thisActivity().sendBroadcast(paramIntent);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    if (thisActivity() != null) {
      thisActivity().setRequestedOrientation(paramInt);
    }
  }
  
  public void setResult(int paramInt)
  {
    if (this.isCurrentActivity) {
      thisActivity().setResult(paramInt);
    }
  }
  
  public void setResult(int paramInt, Intent paramIntent)
  {
    if (this.isCurrentActivity)
    {
      thisActivity().setResult(paramInt);
      return;
    }
    thisActivity().setResult(paramInt, paramIntent);
  }
  
  public void startActivity(Intent paramIntent)
  {
    Object localObject = thisActivity();
    if (localObject == null)
    {
      localObject = MMApplicationContext.getContext();
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramIntent.aFh(), "com/tencent/mm/ui/FragmentActivitySupport", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject).startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/FragmentActivitySupport", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      return;
    }
    ((FragmentActivity)localObject).startActivityFromFragment(this, paramIntent, -1);
  }
  
  public void startFragment(Class<?> paramClass, Intent paramIntent)
  {
    if (this.isCurrentActivity)
    {
      paramClass = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramClass.aFh(), "com/tencent/mm/ui/FragmentActivitySupport", "startFragment", "(Ljava/lang/Class;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramClass.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/FragmentActivitySupport", "startFragment", "(Ljava/lang/Class;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public FragmentActivity thisActivity()
  {
    if (this.mActivity == null) {
      this.mActivity = getActivity();
    }
    return this.mActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.FragmentActivitySupport
 * JD-Core Version:    0.7.0.1
 */