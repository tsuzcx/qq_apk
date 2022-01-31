package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.h.a.gj;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.a.d;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class SettingsFontUI
  extends MMActivity
{
  private int nUi = 0;
  private int nUj = 2;
  private int nUk = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), a.d.chatting_normal_item_width);
  final float nUl = SetTextSizeUI.ea(this.mController.uMN);
  
  private void ay(float paramFloat)
  {
    float f = this.mController.uMN.getSharedPreferences(ae.cqR(), 0).getFloat("current_text_size_scale_key", 1.0F);
    y.i("MicroMsg.SettingsFontUI", "fontSizeAfter=" + f);
    if (paramFloat != f)
    {
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("Intro_Need_Clear_Top ", true);
      com.tencent.mm.plugin.setting.b.eUR.q((Intent)localObject, this.mController.uMN);
      localObject = new gj();
      ((gj)localObject).bOg.bOh = paramFloat;
      ((gj)localObject).bOg.bOi = f;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      com.tencent.mm.cl.b.afs("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
    }
  }
  
  protected final int getLayoutId()
  {
    return a.g.settings_font_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.settings_text_size);
    y.i("MicroMsg.SettingsFontUI", "fontSizeBefore=" + this.nUl);
    Object localObject = (ImageView)findViewById(a.f.chatting_avatar_iv_to);
    TextView localTextView1 = (TextView)findViewById(a.f.settings_font_msg_to);
    TextView localTextView2 = (TextView)findViewById(a.f.settings_font_illustrate_one);
    TextView localTextView3 = (TextView)findViewById(a.f.settings_font_illustrate_two);
    a.b.a((ImageView)localObject, q.Gj());
    localObject = (FontSelectorView)findViewById(a.f.font_selector_view);
    float f2 = SetTextSizeUI.ea(this.mController.uMN);
    float f1;
    if (f2 >= 0.875F)
    {
      f1 = f2;
      if (f2 <= 2.025F) {}
    }
    else
    {
      f1 = 1.0F;
    }
    int i;
    if (f1 == 0.875F) {
      i = 0;
    }
    for (;;)
    {
      ((FontSelectorView)localObject).setSliderIndex(i);
      ((FontSelectorView)localObject).setOnChangeListener(new SettingsFontUI.1(this, localTextView1, localTextView2, localTextView3));
      setBackBtn(new SettingsFontUI.2(this));
      return;
      if (f1 == 1.125F) {
        i = 2;
      } else if (f1 == 1.25F) {
        i = 3;
      } else if (f1 == 1.375F) {
        i = 4;
      } else if (f1 == 1.625F) {
        i = 5;
      } else if (f1 == 1.875F) {
        i = 6;
      } else if (f1 == 2.025F) {
        i = 7;
      } else {
        i = 1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
    {
      h.nFQ.f(11609, new Object[] { Integer.valueOf(this.nUi), Integer.valueOf(this.nUj), Integer.valueOf(0) });
      y.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%d , changeFontSize: %d, curFontSize:%d", new Object[] { Integer.valueOf(11609), Integer.valueOf(this.nUi), Integer.valueOf(this.nUj) });
      finish();
      ay(this.nUl);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI
 * JD-Core Version:    0.7.0.1
 */