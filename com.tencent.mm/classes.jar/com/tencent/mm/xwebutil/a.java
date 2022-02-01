package com.tencent.mm.xwebutil;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.comm.c.b;
import com.tencent.mm.plugin.comm.c.d;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.plugin.comm.c.f;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.d;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.h;
import com.tencent.xweb.h.a;
import com.tencent.xweb.i;
import com.tencent.xweb.j;
import com.tencent.xweb.j.c;
import java.util.HashMap;

public final class a
{
  public static a agZv;
  
  private static ViewGroup a(MMActivity paramMMActivity, String paramString, ValueCallback<String> paramValueCallback, boolean paramBoolean)
  {
    AppMethodBeat.i(177308);
    View localView = af.mU(paramMMActivity.getContext()).inflate(c.f.xweb_file_reader_actionbar, new LinearLayout(paramMMActivity.getContext()), false);
    TextView localTextView1 = (TextView)localView.findViewById(c.e.xweb_file_reader_actionbar_text1);
    TextView localTextView2 = (TextView)localView.findViewById(c.e.xweb_file_reader_actionbar_text2);
    LinearLayout localLinearLayout1 = (LinearLayout)localView.findViewById(c.e.xweb_file_reader_actionbar_title_ll);
    LinearLayout localLinearLayout2 = (LinearLayout)localView.findViewById(c.e.xweb_file_reader_actionbar_up_indicator);
    ImageButton localImageButton1 = (ImageButton)localView.findViewById(c.e.xweb_file_reader_actionbar_up_indicator_btn);
    LinearLayout localLinearLayout3 = (LinearLayout)localView.findViewById(c.e.xweb_file_reader_actionbar_menu_ll);
    ImageButton localImageButton2 = (ImageButton)localView.findViewById(c.e.xweb_file_reader_actionbar_menu_btn);
    if ((localTextView1 == null) || (localTextView2 == null) || (localLinearLayout1 == null) || (localLinearLayout2 == null) || (localImageButton1 == null) || (localLinearLayout3 == null) || (localImageButton2 == null))
    {
      Log.e("XFilesReaderLogic", "initView can not find view");
      AppMethodBeat.o(177308);
      return null;
    }
    int i = paramMMActivity.getResources().getColor(c.b.normal_actionbar_color);
    if (aw.isDarkMode())
    {
      c(paramMMActivity, i);
      localImageButton1.setImageResource(c.d.actionbar_icon_light_back);
      localImageButton2.setImageResource(c.d.actionbar_icon_light_more);
      localLinearLayout2.setVisibility(0);
      localImageButton1.setVisibility(0);
      localImageButton1.setOnClickListener(new a.5(paramValueCallback));
      localLinearLayout3.setVisibility(0);
      if (!paramBoolean) {
        break label455;
      }
      localImageButton2.setVisibility(0);
      localImageButton2.setOnClickListener(new a.6(paramValueCallback));
      label266:
      localLinearLayout1.setVisibility(0);
      localTextView2.setVisibility(0);
      localTextView2.setText(c.h.xweb_file_reader_title);
      localTextView1.setVisibility(0);
      localTextView1.setText(paramString);
      paramString = new FrameLayout(paramMMActivity);
      paramString.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      if (!aw.isDarkMode()) {
        break label465;
      }
      paramString.setBackgroundColor(-15132391);
    }
    for (;;)
    {
      paramValueCallback = new RelativeLayout(paramMMActivity);
      paramValueCallback.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      paramValueCallback.setTag("view_tag_relative_layout");
      paramString.addView(paramValueCallback);
      paramValueCallback = new Toolbar(paramMMActivity);
      paramValueCallback.setLayoutParams(new Toolbar.LayoutParams(-1));
      paramValueCallback.setBackgroundColor(i);
      paramValueCallback.fs();
      paramValueCallback.setTag("view_tag_toolbar");
      paramString.addView(paramValueCallback);
      paramMMActivity.setContentView(paramString);
      paramMMActivity.setSupportActionBar(paramValueCallback);
      paramMMActivity = d.c(paramMMActivity.getSupportActionBar());
      if (paramMMActivity != null) {
        break label474;
      }
      AppMethodBeat.o(177308);
      return null;
      localImageButton1.setImageResource(c.d.actionbar_icon_dark_back);
      localImageButton2.setImageResource(c.d.actionbar_icon_dark_more);
      break;
      label455:
      localImageButton2.setVisibility(8);
      break label266;
      label465:
      paramString.setBackgroundColor(-3355444);
    }
    label474:
    paramMMActivity.x(false);
    paramMMActivity.w(false);
    paramMMActivity.v(false);
    paramMMActivity.y(true);
    paramMMActivity.setCustomView(localView);
    AppMethodBeat.o(177308);
    return paramString;
  }
  
  static void a(int paramInt, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, boolean paramBoolean3)
  {
    AppMethodBeat.i(231700);
    if (paramBoolean1) {
      h.bHu(paramString3);
    }
    if ((agZv != null) && (agZv.csh()))
    {
      if (agZv.csi())
      {
        Log.i("XFilesReaderLogic", "need download miniqb to continue");
        agZv.csj();
        AppMethodBeat.o(231700);
        return;
      }
      Log.i("XFilesReaderLogic", "load by mini qb file loader");
      agZv.d(paramInt, paramContext, paramString1, paramString3, paramString4, paramBoolean2, paramHashMap, paramValueCallback, new a.1(paramBoolean1, paramString3, paramValueCallback1));
      AppMethodBeat.o(231700);
      return;
    }
    i.e(paramInt, paramContext, paramString1, paramString3, paramString4, paramBoolean2, paramHashMap, paramValueCallback, new a.2(paramBoolean1, paramString3, paramValueCallback1, paramContext, paramString1, paramString2, paramString4, paramHashMap, paramValueCallback, paramBoolean3));
    AppMethodBeat.o(231700);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, h.a parama, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, boolean paramBoolean)
  {
    AppMethodBeat.i(231684);
    a(paramContext, paramString1, paramString2, paramString3, paramString4, false, new HashMap(), parama, paramValueCallback, paramValueCallback1, paramBoolean);
    AppMethodBeat.o(231684);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, HashMap<String, String> paramHashMap, h.a parama, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, boolean paramBoolean2)
  {
    AppMethodBeat.i(177306);
    boolean bool;
    String str;
    if (!paramBoolean2)
    {
      bool = true;
      paramHashMap.put("hide_title_bar_right_button", String.valueOf(bool));
      str = bFg(paramString1);
      if (paramString3 == null) {
        break label208;
      }
    }
    label208:
    for (paramString1 = paramString3.toLowerCase();; paramString1 = paramString3)
    {
      c.nU(MMApplicationContext.getContext());
      if (paramBoolean1)
      {
        a(40, paramContext, str, paramString2, paramString1, paramString4, false, true, paramHashMap, paramValueCallback, paramValueCallback1, paramBoolean2);
        AppMethodBeat.o(177306);
        return;
        bool = false;
        break;
      }
      h.qQ(str, paramString1);
      paramString3 = new Intent();
      parama = h.a(paramString1, parama, true, paramString3);
      switch (a.8.agZA[parama.ordinal()])
      {
      default: 
        a(paramString3.getIntExtra(h.aies, 40), paramContext, str, paramString2, paramString1, paramString4, false, false, paramHashMap, paramValueCallback, paramValueCallback1, paramBoolean2);
        AppMethodBeat.o(177306);
        return;
      }
      a(paramContext, str, paramString2, paramString1, paramString4, false, com.tencent.xweb.b.kfi().kfl(), paramHashMap, paramValueCallback, paramValueCallback1, paramBoolean2);
      AppMethodBeat.o(177306);
      return;
    }
  }
  
  static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1, boolean paramBoolean3)
  {
    AppMethodBeat.i(231705);
    if (paramBoolean1) {
      h.bHw(paramString3);
    }
    if (!(paramContext instanceof MMActivity))
    {
      Log.e("XFilesReaderLogic", "readFileByXWeb not mmactivity, use x5");
      if (!paramBoolean1) {
        a(48, paramContext, paramString1, paramString2, paramString3, paramString4, true, false, paramHashMap, paramValueCallback, paramValueCallback1, paramBoolean3);
      }
      AppMethodBeat.o(231705);
      return;
    }
    MMActivity localMMActivity = (MMActivity)paramContext;
    ViewGroup localViewGroup = a(localMMActivity, paramString2, paramValueCallback, paramBoolean3);
    if (localViewGroup == null)
    {
      Log.e("XFilesReaderLogic", "readFileByXWeb contentView is null, use x5");
      if (!paramBoolean1) {
        a(48, paramContext, paramString1, paramString2, paramString3, paramString4, true, false, paramHashMap, paramValueCallback, paramValueCallback1, paramBoolean3);
      }
      AppMethodBeat.o(231705);
      return;
    }
    j.a(paramString1, paramString3, paramString4, paramBoolean2, j.c.aieQ, localMMActivity, localViewGroup, new a.3(paramValueCallback), new a.4(paramValueCallback1, paramBoolean1, paramString3, paramContext, paramString1, paramString2, paramString4, paramHashMap, paramValueCallback, paramBoolean3));
    AppMethodBeat.o(231705);
  }
  
  public static void a(final MMActivity paramMMActivity, String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(152904);
    Log.i("XFilesReaderLogic", "sendFileToFriend, start filePath: ".concat(String.valueOf(paramString1)));
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("desc_title", paramString2);
    localIntent.putExtra("Retr_Msg_Type", 3);
    com.tencent.mm.br.c.a(paramMMActivity, ".ui.transmit.SelectConversationUI", localIntent, 1, new MMActivity.a()
    {
      public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(231681);
        if ((paramAnonymousInt1 != 1) || (paramAnonymousInt2 != -1))
        {
          Log.e("XFilesReaderLogic", "sendFileToFriend, mmOnActivityResult fail, resultCode not ok");
          AppMethodBeat.o(231681);
          return;
        }
        if (paramAnonymousIntent == null)
        {
          Log.e("XFilesReaderLogic", "sendFileToFriend, mmOnActivityResult fail, retData is null");
          AppMethodBeat.o(231681);
          return;
        }
        String str = paramAnonymousIntent.getStringExtra("Select_Conv_User");
        paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
        if ((str == null) || (str.length() == 0))
        {
          Log.e("XFilesReaderLogic", "sendFileToFriend, mmOnActivityResult fail, toUser is null");
          AppMethodBeat.o(231681);
          return;
        }
        Log.i("XFilesReaderLogic", "sendFileToFriend, send broadcast, filePath: " + a.this);
        Intent localIntent = new Intent();
        localIntent.setAction("MINIQB_OPEN_RET");
        localIntent.putExtra("op_type", "SEND_TO_FRIENDS");
        localIntent.putExtra("file_path", a.this);
        localIntent.putExtra("file_name", paramString2);
        localIntent.putExtra("file_ext", paramString3);
        localIntent.putExtra("to_user", str);
        localIntent.putExtra("send_text", paramAnonymousIntent);
        paramMMActivity.sendBroadcast(localIntent, WeChatPermissions.PERMISSION_MM_MESSAGE());
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(231647);
            com.tencent.mm.ui.widget.snackbar.b.u(a.7.this.val$activity, a.7.this.val$activity.getString(c.h.xweb_file_reader_send_success));
            AppMethodBeat.o(231647);
          }
        });
        AppMethodBeat.o(231681);
      }
    });
    AppMethodBeat.o(152904);
  }
  
  public static void am(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(152898);
    if ((agZv != null) && (agZv.csh()))
    {
      agZv.v(paramContext, paramString1, paramString2);
      AppMethodBeat.o(152898);
      return;
    }
    paramString2 = bFg(paramString2);
    j.qS(paramString1, paramString2);
    i.t(paramContext, paramString1, paramString2);
    AppMethodBeat.o(152898);
  }
  
  public static String bFg(String paramString)
  {
    AppMethodBeat.i(152899);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("XFilesReaderLogic", "getSafeRealPath filePath is empty");
      AppMethodBeat.o(152899);
      return paramString;
    }
    try
    {
      String str = y.n(paramString, false);
      if (Util.isNullOrNil(str))
      {
        Log.e("XFilesReaderLogic", "getSafeRealPath real path is empty, use old path %s", new Object[] { paramString });
        AppMethodBeat.o(152899);
        return paramString;
      }
      if (str.equals(paramString))
      {
        Log.i("XFilesReaderLogic", "getSafeRealPath real path is the same %s", new Object[] { str });
        AppMethodBeat.o(152899);
        return str;
      }
      Log.i("XFilesReaderLogic", "getSafeRealPath from %s to %s", new Object[] { paramString, str });
      AppMethodBeat.o(152899);
      return str;
    }
    catch (Exception localException)
    {
      Log.e("XFilesReaderLogic", "getSafeRealPath error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(152899);
    }
    return paramString;
  }
  
  private static void c(MMActivity paramMMActivity, int paramInt)
  {
    AppMethodBeat.i(177309);
    try
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramMMActivity = paramMMActivity.getWindow();
        if (paramMMActivity == null)
        {
          AppMethodBeat.o(177309);
          return;
        }
        paramMMActivity.clearFlags(201326592);
        paramMMActivity.addFlags(-2147483648);
        paramMMActivity.setStatusBarColor(paramInt);
        if (Build.VERSION.SDK_INT >= 23)
        {
          paramMMActivity = paramMMActivity.getDecorView();
          paramMMActivity.setSystemUiVisibility(paramMMActivity.getSystemUiVisibility() & 0xFFFFDFFF);
        }
      }
      AppMethodBeat.o(177309);
      return;
    }
    catch (Exception paramMMActivity)
    {
      Log.e("XFilesReaderLogic", "updateStatusBarToDarkMode error ", new Object[] { paramMMActivity });
      AppMethodBeat.o(177309);
    }
  }
  
  public static void h(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(152903);
    if ((paramContext == null) || (paramString1 == null) || (paramString1.isEmpty()) || (paramString2 == null) || (paramString2.isEmpty()))
    {
      Log.e("XFilesReaderLogic", "sendResult wrong param");
      AppMethodBeat.o(152903);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("MINIQB_OPEN_RET");
    localIntent.putExtra("op_type", "NOTIFY_RET");
    localIntent.putExtra("file_path", paramString1);
    localIntent.putExtra("file_ext", paramString2);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("MINIQB_OPEN_RET_VAL", bool);
      paramContext.sendBroadcast(localIntent, WeChatPermissions.PERMISSION_MM_MESSAGE());
      AppMethodBeat.o(152903);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean csh();
    
    public abstract boolean csi();
    
    public abstract void csj();
    
    public abstract void d(int paramInt, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1);
    
    public abstract void v(Context paramContext, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.xwebutil.a
 * JD-Core Version:    0.7.0.1
 */