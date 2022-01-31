package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.b;

public class SetTextSizeUI
  extends MMPreference
{
  private f dnn;
  private float nSL;
  private int nSM = 1;
  
  public static float ax(float paramFloat)
  {
    float f2 = 16.0F;
    float f1;
    if (paramFloat == 0.875F) {
      f1 = 14.0F;
    }
    do
    {
      do
      {
        return f1;
        f1 = f2;
      } while (paramFloat == 1.0F);
      if (paramFloat == 1.125F) {
        return 18.0F;
      }
      if (paramFloat == 1.25F) {
        return 20.0F;
      }
      if (paramFloat == 1.375F) {
        return 22.0F;
      }
      if (paramFloat == 1.625F) {
        return 26.0F;
      }
      if (paramFloat == 1.875F) {
        return 28.0F;
      }
      f1 = f2;
    } while (paramFloat != 2.025F);
    return 30.0F;
  }
  
  public static float ea(Context paramContext)
  {
    float f = a.cJ(paramContext);
    if ((f != 1.0F) && (f != 0.875F) && (f != 1.125F) && (f != 1.25F) && (f != 1.375F) && (f != 1.625F) && (f != 1.875F) && (f != 2.025F)) {
      return 1.0F;
    }
    return f;
  }
  
  public static int eb(Context paramContext)
  {
    float f = ea(paramContext);
    if (f == 0.875F) {
      return a.i.setting_text_size_small;
    }
    if (f == 1.125F) {
      return a.i.setting_text_size_large;
    }
    if (f == 1.25F) {
      return a.i.setting_text_size_super;
    }
    if (f == 1.375F) {
      return a.i.setting_text_size_huge;
    }
    return a.i.setting_text_size_normal;
  }
  
  private void refresh()
  {
    this.dnn.removeAll();
    Object localObject = new SetTextSizeUI.a(this, this, 0.875F);
    ((Preference)localObject).setKey("setting_text_size_small");
    ((Preference)localObject).setLayoutResource(a.g.mm_preference);
    if (this.nSL == 0.875F)
    {
      ((Preference)localObject).setWidgetLayoutResource(a.g.mm_preference_radio_checked);
      this.dnn.a((Preference)localObject);
      localObject = new SetTextSizeUI.a(this, this, 1.0F);
      ((Preference)localObject).setKey("setting_text_size_normal");
      ((Preference)localObject).setLayoutResource(a.g.mm_preference);
      if (this.nSL != 1.0F) {
        break label375;
      }
      ((Preference)localObject).setWidgetLayoutResource(a.g.mm_preference_radio_checked);
      label101:
      this.dnn.a((Preference)localObject);
      localObject = new SetTextSizeUI.a(this, this, 1.125F);
      ((Preference)localObject).setKey("setting_text_size_large");
      ((Preference)localObject).setLayoutResource(a.g.mm_preference);
      if (this.nSL != 1.125F) {
        break label385;
      }
      ((Preference)localObject).setWidgetLayoutResource(a.g.mm_preference_radio_checked);
      label153:
      this.dnn.a((Preference)localObject);
      localObject = new SetTextSizeUI.a(this, this, 1.25F);
      ((Preference)localObject).setKey("setting_text_size_super");
      ((Preference)localObject).setLayoutResource(a.g.mm_preference);
      if (this.nSL != 1.25F) {
        break label395;
      }
      ((Preference)localObject).setWidgetLayoutResource(a.g.mm_preference_radio_checked);
      label205:
      this.dnn.a((Preference)localObject);
      localObject = new SetTextSizeUI.a(this, this, 1.375F);
      ((Preference)localObject).setKey("setting_text_size_huge");
      ((Preference)localObject).setLayoutResource(a.g.mm_preference);
      if (this.nSL != 1.375F) {
        break label405;
      }
      ((Preference)localObject).setWidgetLayoutResource(a.g.mm_preference_radio_checked);
    }
    for (;;)
    {
      this.dnn.a((Preference)localObject);
      localObject = new PreferenceCategory(this);
      this.dnn.a((Preference)localObject);
      this.dnn.notifyDataSetChanged();
      localObject = (ViewGroup)this.mController.uMz;
      int i = 0;
      int j = ((ViewGroup)localObject).getChildCount();
      while (i < j)
      {
        View localView = ((ViewGroup)localObject).getChildAt(i);
        if ((localView instanceof TextView)) {
          y.d("ui.settings.SetTextSize", "id=" + localView.getId());
        }
        i += 1;
      }
      ((Preference)localObject).setWidgetLayoutResource(a.g.mm_preference_radio_unchecked);
      break;
      label375:
      ((Preference)localObject).setWidgetLayoutResource(a.g.mm_preference_radio_unchecked);
      break label101;
      label385:
      ((Preference)localObject).setWidgetLayoutResource(a.g.mm_preference_radio_unchecked);
      break label153;
      label395:
      ((Preference)localObject).setWidgetLayoutResource(a.g.mm_preference_radio_unchecked);
      break label205;
      label405:
      ((Preference)localObject).setWidgetLayoutResource(a.g.mm_preference_radio_unchecked);
    }
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    this.nSM = 1;
    if (paramf.equals("setting_text_size_small"))
    {
      this.nSL = 0.875F;
      this.nSM = 0;
    }
    for (;;)
    {
      refresh();
      return false;
      if (paramf.equals("setting_text_size_normal"))
      {
        this.nSL = 1.0F;
        this.nSM = 1;
      }
      else if (paramf.equals("setting_text_size_large"))
      {
        this.nSL = 1.125F;
        this.nSM = 2;
      }
      else if (paramf.equals("setting_text_size_super"))
      {
        this.nSL = 1.25F;
        this.nSM = 3;
      }
      else if (paramf.equals("setting_text_size_huge"))
      {
        this.nSL = 1.375F;
        this.nSM = 4;
      }
      else if (paramf.equals("setting_text_size_huger"))
      {
        this.nSL = 1.625F;
        this.nSM = 5;
      }
      else if (paramf.equals("setting_text_size_hugers"))
      {
        this.nSL = 1.625F;
        this.nSM = 6;
      }
      else if (paramf.equals("setting_text_size_hugerss"))
      {
        this.nSL = 1.625F;
        this.nSM = 7;
      }
    }
  }
  
  protected final void initView()
  {
    this.nSL = ea(this);
    this.dnn = this.vdd;
    setMMTitle(a.i.settings_text_size);
    setBackBtn(new SetTextSizeUI.1(this));
    a(0, getString(a.i.settings_language_save), new SetTextSizeUI.2(this), s.b.uNx);
    refresh();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public final int xj()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SetTextSizeUI
 * JD-Core Version:    0.7.0.1
 */