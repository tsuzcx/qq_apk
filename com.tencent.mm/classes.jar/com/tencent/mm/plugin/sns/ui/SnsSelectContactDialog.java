package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.h.c.as;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.MMBaseActivity;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsSelectContactDialog
  extends MMBaseActivity
{
  private List<String> items = new LinkedList();
  private GridView pbF = null;
  private a pbG = null;
  
  private boolean Po(String paramString)
  {
    String[] arrayOfString = s.dVc;
    int j = arrayOfString.length;
    int i = 0;
    if (i < j) {
      if (!paramString.equals(arrayOfString[i])) {}
    }
    while ((s.fn(paramString)) || (s.hl(paramString)) || ((this.items != null) && (this.items.contains(paramString))))
    {
      return false;
      i += 1;
      break;
    }
    return true;
  }
  
  private String bJi()
  {
    Object localObject1 = ((j)g.r(j.class)).FB();
    Object localObject2 = s.dUT;
    Object localObject3 = new LinkedList();
    String[] arrayOfString = s.dVc;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      ((List)localObject3).add(arrayOfString[i]);
      i += 1;
    }
    ((List)localObject3).add("weixin");
    ((List)localObject3).add("officialaccounts");
    ((List)localObject3).add("helper_entry");
    ((List)localObject3).add("filehelper");
    localObject1 = ((be)localObject1).c((String)localObject2, (List)localObject3, "*");
    if (((Cursor)localObject1).getCount() == 0)
    {
      ((Cursor)localObject1).close();
      return "";
    }
    localObject2 = new LinkedList();
    ((Cursor)localObject1).moveToFirst();
    do
    {
      localObject3 = new ak();
      ((ak)localObject3).d((Cursor)localObject1);
      if (Po(((as)localObject3).field_username))
      {
        ((List)localObject2).add(((as)localObject3).field_username);
        if (((List)localObject2).size() >= 10) {
          break;
        }
      }
    } while (((Cursor)localObject1).moveToNext());
    ((Cursor)localObject1).close();
    return bk.c((List)localObject2, ";");
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1) {}
    do
    {
      do
      {
        return;
        switch (paramInt1)
        {
        default: 
          return;
        }
      } while (paramIntent == null);
      paramIntent = bk.G(paramIntent.getStringExtra("Select_Contact").split(","));
    } while (paramIntent == null);
    if (this.items == null) {
      this.items = new LinkedList();
    }
    paramIntent = paramIntent.iterator();
    while (paramIntent.hasNext())
    {
      String str = (String)paramIntent.next();
      if (!this.items.contains(str)) {
        this.items.add(str);
      }
    }
    y.d("MicroMsg.SnsSelectContactDialog", "withList count " + this.items.size());
    if (this.pbG != null)
    {
      y.d("MicroMsg.SnsSelectContactDialog", "refresh alertAdapter");
      this.pbG.refresh();
    }
    paramIntent = new Intent();
    paramIntent.putExtra("Select_Contact", bk.c(this.items, ","));
    setResult(-1, paramIntent);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(i.g.sns_chose_pic_ui);
    paramBundle = getIntent().getStringExtra("Select_Contact");
    if ((paramBundle == null) || (paramBundle.equals(""))) {
      this.items.clear();
    }
    for (;;)
    {
      this.pbF = ((GridView)findViewById(i.f.content_grid));
      this.pbG = new a(this, this.items);
      this.pbF.setAdapter(this.pbG);
      this.pbF.setOnItemClickListener(new SnsSelectContactDialog.1(this));
      this.pbF.setSelection(this.pbG.getCount() - 1);
      ((ImageButton)findViewById(i.f.close_btn)).setOnClickListener(new SnsSelectContactDialog.2(this));
      return;
      this.items = bk.G(paramBundle.split(","));
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("Select_Contact", bk.c(this.items, ","));
      setResult(-1, localIntent);
      finish();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  final class a
    extends BaseAdapter
  {
    private Context context;
    private List<String> items;
    private int oMu = 0;
    private int type;
    
    public a(int paramInt)
    {
      Object localObject;
      this.items = localObject;
      this.context = paramInt;
      this.type = 0;
      refresh();
    }
    
    public final int getCount()
    {
      return this.oMu;
    }
    
    public final Object getItem(int paramInt)
    {
      return this.items.get(paramInt);
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramViewGroup = new SnsSelectContactDialog.b();
        if (this.type == 0)
        {
          paramView = View.inflate(this.context, i.g.sns_upload_alert_item, null);
          paramViewGroup.jdk = ((ImageView)paramView.findViewById(i.f.image));
          paramViewGroup.pbI = ((ImageView)paramView.findViewById(i.f.item_del));
          paramView.setTag(paramViewGroup);
          label64:
          paramView.setVisibility(0);
          if (paramInt != this.oMu - 1) {
            break label165;
          }
          paramViewGroup.jdk.setBackgroundDrawable(null);
          paramViewGroup.jdk.setImageResource(i.e.sns_add_item);
          paramViewGroup.pbI.setVisibility(8);
          if (this.items.size() >= ab.unw) {
            paramView.setVisibility(8);
          }
        }
      }
      for (;;)
      {
        paramViewGroup.jdk.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return paramView;
        paramView = View.inflate(this.context, i.g.sns_alert_item, null);
        break;
        paramViewGroup = (SnsSelectContactDialog.b)paramView.getTag();
        break label64;
        label165:
        paramViewGroup.jdk.setBackgroundDrawable(null);
        paramViewGroup.pbI.setVisibility(0);
        Object localObject;
        if (this.type == 0)
        {
          localObject = (String)this.items.get(paramInt);
          a.b.a(paramViewGroup.jdk, (String)localObject);
        }
        else
        {
          localObject = c.e((String)this.items.get(paramInt), af.bDN(), af.bDN(), true);
          paramViewGroup.jdk.setImageBitmap((Bitmap)localObject);
        }
      }
    }
    
    public final void refresh()
    {
      if (this.items == null) {}
      for (this.oMu = 0;; this.oMu = this.items.size())
      {
        this.oMu += 1;
        notifyDataSetChanged();
        return;
      }
    }
  }
  
  static final class b
  {
    ImageView jdk;
    ImageView pbI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSelectContactDialog
 * JD-Core Version:    0.7.0.1
 */