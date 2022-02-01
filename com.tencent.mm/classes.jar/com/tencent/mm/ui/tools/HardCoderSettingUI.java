package com.tencent.mm.ui.tools;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.Editable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.sql.Time;
import java.text.DateFormat;

public class HardCoderSettingUI
  extends MMActivity
{
  private TextView Awy;
  private final TimePickerDialog.OnTimeSetListener PrA;
  private boolean Prz;
  private EditText afFA;
  private EditText afFB;
  private Spinner afFC;
  private Spinner afFD;
  private CheckBox afFE;
  private CheckBox afFF;
  private EditText afFG;
  private EditText afFH;
  private EditText afFI;
  private Spinner afFJ;
  private Spinner afFK;
  private CheckBox afFL;
  private CheckBox afFM;
  private EditText afFN;
  private EditText afFO;
  private EditText afFP;
  private Spinner afFQ;
  private Spinner afFR;
  private CheckBox afFS;
  private CheckBox afFT;
  private EditText afFU;
  private EditText afFV;
  private EditText afFW;
  private Spinner afFX;
  private Spinner afFY;
  private CheckBox afFZ;
  private CheckBox afFs;
  private EditText afFt;
  private CheckBox afFu;
  private CheckBox afFv;
  private CheckBox afFw;
  private TextView afFx;
  private CheckBox afFy;
  private EditText afFz;
  private EditText afGA;
  private EditText afGB;
  private EditText afGC;
  private Spinner afGD;
  private Spinner afGE;
  private CheckBox afGF;
  private CheckBox afGG;
  private EditText afGH;
  private EditText afGI;
  private EditText afGJ;
  private Spinner afGK;
  private Spinner afGL;
  private CheckBox afGM;
  private CheckBox afGN;
  private EditText afGO;
  private EditText afGP;
  private EditText afGQ;
  private Spinner afGR;
  private Spinner afGS;
  private CheckBox afGT;
  private CheckBox afGU;
  private EditText afGV;
  private EditText afGW;
  private EditText afGX;
  private Spinner afGY;
  private Spinner afGZ;
  private CheckBox afGa;
  private EditText afGb;
  private EditText afGc;
  private EditText afGd;
  private Spinner afGe;
  private Spinner afGf;
  private CheckBox afGg;
  private CheckBox afGh;
  private EditText afGi;
  private EditText afGj;
  private EditText afGk;
  private Spinner afGl;
  private Spinner afGm;
  private CheckBox afGn;
  private CheckBox afGo;
  private EditText afGp;
  private EditText afGq;
  private EditText afGr;
  private Spinner afGs;
  private Spinner afGt;
  private CheckBox afGu;
  private EditText afGv;
  private CheckBox afGw;
  private EditText afGx;
  private EditText afGy;
  private EditText afGz;
  private Spinner afHA;
  private Spinner afHB;
  private CheckBox afHC;
  private CheckBox afHD;
  private EditText afHE;
  private EditText afHF;
  private EditText afHG;
  private Spinner afHH;
  private Spinner afHI;
  private CheckBox afHJ;
  private CheckBox afHK;
  private EditText afHL;
  private EditText afHM;
  private EditText afHN;
  private Spinner afHO;
  private Spinner afHP;
  private CheckBox afHQ;
  private CheckBox afHR;
  private EditText afHS;
  private EditText afHT;
  private EditText afHU;
  private Spinner afHV;
  private Spinner afHW;
  private CheckBox afHX;
  private CheckBox afHa;
  private CheckBox afHb;
  private EditText afHc;
  private EditText afHd;
  private EditText afHe;
  private Spinner afHf;
  private Spinner afHg;
  private CheckBox afHh;
  private CheckBox afHi;
  private EditText afHj;
  private EditText afHk;
  private EditText afHl;
  private Spinner afHm;
  private Spinner afHn;
  private CheckBox afHo;
  private CheckBox afHp;
  private EditText afHq;
  private EditText afHr;
  private EditText afHs;
  private Spinner afHt;
  private Spinner afHu;
  private CheckBox afHv;
  private CheckBox afHw;
  private EditText afHx;
  private EditText afHy;
  private EditText afHz;
  
  public HardCoderSettingUI()
  {
    AppMethodBeat.i(39064);
    this.Prz = false;
    this.PrA = new TimePickerDialog.OnTimeSetListener()
    {
      public final void onTimeSet(TimePicker paramAnonymousTimePicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(39063);
        if (HardCoderSettingUI.s(HardCoderSettingUI.this))
        {
          WXHardCoderJNI.hcBeginTimeHour = paramAnonymousInt1;
          WXHardCoderJNI.hcBeginTimeMin = paramAnonymousInt2;
          HardCoderSettingUI.t(HardCoderSettingUI.this).setText(HardCoderSettingUI.t(HardCoderSettingUI.this, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin));
          AppMethodBeat.o(39063);
          return;
        }
        WXHardCoderJNI.hcEndTimeHour = paramAnonymousInt1;
        WXHardCoderJNI.hcEndTimeMin = paramAnonymousInt2;
        HardCoderSettingUI.u(HardCoderSettingUI.this).setText(HardCoderSettingUI.t(HardCoderSettingUI.this, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcEndTimeMin));
        AppMethodBeat.o(39063);
      }
    };
    AppMethodBeat.o(39064);
  }
  
  private static void b(SharedPreferences.Editor paramEditor)
  {
    AppMethodBeat.i(39068);
    paramEditor.putBoolean("KEY_HC_ENABLE", WXHardCoderJNI.getEnable());
    paramEditor.putBoolean("KEY_HC_DEBUG", WXHardCoderJNI.getDebug());
    paramEditor.putInt("KEY_HC_RETRY_INTERVAL", WXHardCoderJNI.hcRetryInterval);
    paramEditor.putBoolean("KEY_HC_TIME_LIMIT", WXHardCoderJNI.hcTimeLimit);
    paramEditor.putInt("KEY_HC_BEGIN_TIME_HOUR", WXHardCoderJNI.hcBeginTimeHour);
    paramEditor.putInt("KEY_HC_BEGIN_TIME_MIN", WXHardCoderJNI.hcBeginTimeMin);
    paramEditor.putInt("KEY_HC_END_TIME_HOUR", WXHardCoderJNI.hcEndTimeHour);
    paramEditor.putInt("KEY_HC_END_TIME_MIN", WXHardCoderJNI.hcEndTimeMin);
    paramEditor.putBoolean("KEY_HC_BOOT_ENABLE", WXHardCoderJNI.hcBootEnable);
    paramEditor.putInt("KEY_HC_BOOT_DELEY", WXHardCoderJNI.hcBootDelay);
    paramEditor.putInt("KEY_HC_BOOT_CPU", WXHardCoderJNI.hcBootCPU);
    paramEditor.putInt("KEY_HC_BOOT_IO", WXHardCoderJNI.hcBootIO);
    paramEditor.putBoolean("KEY_HC_BOOT_THR", WXHardCoderJNI.hcBootThr);
    paramEditor.putInt("KEY_HC_BOOT_TIMEOUT", WXHardCoderJNI.hcBootTimeout);
    paramEditor.putLong("KEY_HC_BOOT_ACTION", WXHardCoderJNI.hcBootAction);
    paramEditor.putBoolean("KEY_HC_ENTER_CHATTING_ENABLE", WXHardCoderJNI.hcEnterChattingEnable);
    paramEditor.putInt("KEY_HC_ENTER_CHATTING_DELEY", WXHardCoderJNI.hcEnterChattingDelay);
    paramEditor.putInt("KEY_HC_ENTER_CHATTING_CPU", WXHardCoderJNI.hcEnterChattingCPU);
    paramEditor.putInt("KEY_HC_ENTER_CHATTING_IO", WXHardCoderJNI.hcEnterChattingIO);
    paramEditor.putBoolean("KEY_HC_ENTER_CHATTING_THR", WXHardCoderJNI.hcEnterChattingThr);
    paramEditor.putInt("KEY_HC_ENTER_CHATTING_TIMEOUT", WXHardCoderJNI.hcEnterChattingTimeout);
    paramEditor.putLong("KEY_HC_ENTER_CHATTING_ACTION", WXHardCoderJNI.hcEnterChattingAction);
    paramEditor.putBoolean("KEY_HC_QUIT_CHATTING_ENABLE", WXHardCoderJNI.hcQuitChattingEnable);
    paramEditor.putInt("KEY_HC_QUIT_CHATTING_DELEY", WXHardCoderJNI.hcQuitChattingDelay);
    paramEditor.putInt("KEY_HC_QUIT_CHATTING_CPU", WXHardCoderJNI.hcQuitChattingCPU);
    paramEditor.putInt("KEY_HC_QUIT_CHATTING_IO", WXHardCoderJNI.hcQuitChattingIO);
    paramEditor.putBoolean("KEY_HC_QUIT_CHATTING_THR", WXHardCoderJNI.hcQuitChattingThr);
    paramEditor.putInt("KEY_HC_QUIT_CHATTING_TIMEOUT", WXHardCoderJNI.hcQuitChattingTimeout);
    paramEditor.putLong("KEY_HC_QUIT_CHATTING_ACTION", WXHardCoderJNI.hcQuitChattingAction);
    paramEditor.putBoolean("KEY_HC_SEND_MSG_ENABLE", WXHardCoderJNI.hcSendMsgEnable);
    paramEditor.putInt("KEY_HC_SEND_MSG_DELEY", WXHardCoderJNI.hcSendMsgDelay);
    paramEditor.putInt("KEY_HC_SEND_MSG_CPU", WXHardCoderJNI.hcSendMsgCPU);
    paramEditor.putInt("KEY_HC_SEND_MSG_IO", WXHardCoderJNI.hcSendMsgIO);
    paramEditor.putBoolean("KEY_HC_SEND_MSG_THR", WXHardCoderJNI.hcSendMsgThr);
    paramEditor.putInt("KEY_HC_SEND_MSG_TIMEOUT", WXHardCoderJNI.hcSendMsgTimeout);
    paramEditor.putLong("KEY_HC_SEND_MSG_ACTION", WXHardCoderJNI.hcSendMsgAction);
    paramEditor.putBoolean("KEY_HC_SEND_PIC_MSG_ENABLE", WXHardCoderJNI.hcSendPicMsgEnable);
    paramEditor.putInt("KEY_HC_SEND_PIC_MSG_DELEY", WXHardCoderJNI.hcSendPicMsgDelay);
    paramEditor.putInt("KEY_HC_SEND_PIC_MSG_CPU", WXHardCoderJNI.hcSendPicMsgCPU);
    paramEditor.putInt("KEY_HC_SEND_PIC_MSG_IO", WXHardCoderJNI.hcSendPicMsgIO);
    paramEditor.putBoolean("KEY_HC_SEND_PIC_MSG_THR", WXHardCoderJNI.hcSendPicMsgThr);
    paramEditor.putInt("KEY_HC_SEND_PIC_MSG_TIMEOUT", WXHardCoderJNI.hcSendPicMsgTimeout);
    paramEditor.putLong("KEY_HC_SEND_PIC_MSG_ACTION", WXHardCoderJNI.hcSendPicMsgAction);
    paramEditor.putBoolean("KEY_HC_RECEIVE_MSG_ENABLE", WXHardCoderJNI.hcReceiveMsgEnable);
    paramEditor.putInt("KEY_HC_RECEIVE_MSG_DELEY", WXHardCoderJNI.hcReceiveMsgDelay);
    paramEditor.putInt("KEY_HC_RECEIVE_MSG_CPU", WXHardCoderJNI.hcReceiveMsgCPU);
    paramEditor.putInt("KEY_HC_RECEIVE_MSG_IO", WXHardCoderJNI.hcReceiveMsgIO);
    paramEditor.putBoolean("KEY_HC_RECEIVE_MSG_THR", WXHardCoderJNI.hcReceiveMsgThr);
    paramEditor.putInt("KEY_HC_RECEIVE_MSG_TIMEOUT", WXHardCoderJNI.hcReceiveMsgTimeout);
    paramEditor.putLong("KEY_HC_RECEIVE_MSG_ACTION", WXHardCoderJNI.hcReceiveMsgAction);
    paramEditor.putBoolean("KEY_HC_UPDATE_CHATROOM_ENABLE", WXHardCoderJNI.hcUpdateChatroomEnable);
    paramEditor.putInt("KEY_HC_UPDATE_CHATROOM_DELEY", WXHardCoderJNI.hcUpdateChatroomDelay);
    paramEditor.putInt("KEY_HC_UPDATE_CHATROOM_CPU", WXHardCoderJNI.hcUpdateChatroomCPU);
    paramEditor.putInt("KEY_HC_UPDATE_CHATROOM_IO", WXHardCoderJNI.hcUpdateChatroomIO);
    paramEditor.putBoolean("KEY_HC_UPDATE_CHATROOM_THR", WXHardCoderJNI.hcUpdateChatroomThr);
    paramEditor.putInt("KEY_HC_UPDATE_CHATROOM_TIMEOUT", WXHardCoderJNI.hcUpdateChatroomTimeout);
    paramEditor.putLong("KEY_HC_UPDATE_CHATROOM_ACTION", WXHardCoderJNI.hcUpdateChatroomAction);
    paramEditor.putLong("KEY_HC_UPDATE_CHATROOM_MEMBER_COUNT", WXHardCoderJNI.hcUpdateChatroomMemberCount);
    paramEditor.putBoolean("KEY_HC_DB_ENABLE", WXHardCoderJNI.hcDBEnable);
    paramEditor.putInt("KEY_HC_DB_DELEY_QUERY", WXHardCoderJNI.hcDBDelayQuery);
    paramEditor.putInt("KEY_HC_DB_DELEY_WRITE", WXHardCoderJNI.hcDBDelayWrite);
    paramEditor.putInt("KEY_HC_DB_CPU", WXHardCoderJNI.hcDBCPU);
    paramEditor.putInt("KEY_HC_DB_IO", WXHardCoderJNI.hcDBIO);
    paramEditor.putBoolean("KEY_HC_DB_THR", WXHardCoderJNI.hcDBThr);
    paramEditor.putInt("KEY_HC_DB_TIMEOUT", WXHardCoderJNI.hcDBTimeout);
    paramEditor.putInt("KEY_HC_DB_TIMEOUT", WXHardCoderJNI.hcDBTimeoutBusy);
    paramEditor.putLong("KEY_HC_DB_ACTION_QUERY", WXHardCoderJNI.hcDBActionQuery);
    paramEditor.putLong("KEY_HC_DB_ACTION_WRITE", WXHardCoderJNI.hcDBActionWrite);
    paramEditor.putBoolean("KEY_HC_ENCODE_VIDEO_ENABLE", WXHardCoderJNI.hcEncodeVideoEnable);
    paramEditor.putInt("KEY_HC_ENCODE_VIDEO_DELEY", WXHardCoderJNI.hcEncodeVideoDelay);
    paramEditor.putInt("KEY_HC_ENCODE_VIDEO_CPU", WXHardCoderJNI.hcEncodeVideoCPU);
    paramEditor.putInt("KEY_HC_ENCODE_VIDEO_IO", WXHardCoderJNI.hcEncodeVideoIO);
    paramEditor.putBoolean("KEY_HC_ENCODE_VIDEO_THR", WXHardCoderJNI.hcEncodeVideoThr);
    paramEditor.putInt("KEY_HC_ENCODE_VIDEO_TIMEOUT", WXHardCoderJNI.hcEncodeVideoTimeout);
    paramEditor.putLong("KEY_HC_ENCODE_VIDEO_ACTION", WXHardCoderJNI.hcEncodeVideoAction);
    paramEditor.putBoolean("KEY_HC_DECODE_PIC_ENABLE", WXHardCoderJNI.hcDecodePicEnable);
    paramEditor.putInt("KEY_HC_DECODE_PIC_DELEY", WXHardCoderJNI.hcDecodePicDelay);
    paramEditor.putInt("KEY_HC_DECODE_PIC_CPU", WXHardCoderJNI.hcDecodePicCPU);
    paramEditor.putInt("KEY_HC_DECODE_PIC_IO", WXHardCoderJNI.hcDecodePicIO);
    paramEditor.putBoolean("KEY_HC_DECODE_PIC_THR", WXHardCoderJNI.hcDecodePicThr);
    paramEditor.putInt("KEY_HC_DECODE_PIC_TIMEOUT", WXHardCoderJNI.hcDecodePicTimeout);
    paramEditor.putLong("KEY_HC_DECODE_PIC_ACTION", WXHardCoderJNI.hcDecodePicAction);
    paramEditor.putBoolean("KEY_HC_GIF_ENABLE", WXHardCoderJNI.hcGifEnable);
    paramEditor.putInt("KEY_HC_GIF_DELEY", WXHardCoderJNI.hcGifDelay);
    paramEditor.putInt("KEY_HC_GIF_CPU", WXHardCoderJNI.hcGifCPU);
    paramEditor.putInt("KEY_HC_GIF_IO", WXHardCoderJNI.hcGifIO);
    paramEditor.putBoolean("KEY_HC_GIF_THR", WXHardCoderJNI.hcGifThr);
    paramEditor.putInt("KEY_HC_GIF_TIMEOUT", WXHardCoderJNI.hcGifTimeout);
    paramEditor.putLong("KEY_HC_GIF_ACTION", WXHardCoderJNI.hcGifAction);
    paramEditor.putBoolean("KEY_HC_GIF_FRAME_ENABLE", WXHardCoderJNI.hcGifFrameEnable);
    paramEditor.putInt("KEY_HC_GIF_FRAME_DELEY", WXHardCoderJNI.hcGifFrameDelay);
    paramEditor.putInt("KEY_HC_GIF_FRAME_CPU", WXHardCoderJNI.hcGifFrameCPU);
    paramEditor.putInt("KEY_HC_GIF_FRAME_IO", WXHardCoderJNI.hcGifFrameIO);
    paramEditor.putBoolean("KEY_HC_GIF_FRAME_THR", WXHardCoderJNI.hcGifFrameThr);
    paramEditor.putInt("KEY_HC_GIF_FRAME_TIMEOUT", WXHardCoderJNI.hcGifFrameTimeout);
    paramEditor.putLong("KEY_HC_GIF_FRAME_ACTION", WXHardCoderJNI.hcGifFrameAction);
    paramEditor.putBoolean("KEY_HC_SNS_SCROLL_ENABLE", WXHardCoderJNI.hcSNSScrollEnable);
    paramEditor.putInt("KEY_HC_SNS_SCROLL_DELEY", WXHardCoderJNI.hcSNSScrollDelay);
    paramEditor.putInt("KEY_HC_SNS_SCROLL_CPU", WXHardCoderJNI.hcSNSScrollCPU);
    paramEditor.putInt("KEY_HC_SNS_SCROLL_IO", WXHardCoderJNI.hcSNSScrollIO);
    paramEditor.putBoolean("KEY_HC_SNS_SCROLL_THR", WXHardCoderJNI.hcSNSScrollThr);
    paramEditor.putInt("KEY_HC_SNS_SCROLL_TIMEOUT", WXHardCoderJNI.hcSNSScrollTimeout);
    paramEditor.putLong("KEY_HC_SNS_SCROLL_ACTION", WXHardCoderJNI.hcSNSScrollAction);
    paramEditor.putBoolean("KEY_HC_SNS_USER_SCROLL_ENABLE", WXHardCoderJNI.hcSNSUserScrollEnable);
    paramEditor.putInt("KEY_HC_SNS_USER_SCROLL_DELEY", WXHardCoderJNI.hcSNSUserScrollDelay);
    paramEditor.putInt("KEY_HC_SNS_USER_SCROLL_CPU", WXHardCoderJNI.hcSNSUserScrollCPU);
    paramEditor.putInt("KEY_HC_SNS_USER_SCROLL_IO", WXHardCoderJNI.hcSNSUserScrollIO);
    paramEditor.putBoolean("KEY_HC_SNS_USER_SCROLL_THR", WXHardCoderJNI.hcSNSUserScrollThr);
    paramEditor.putInt("KEY_HC_SNS_USER_SCROLL_TIMEOUT", WXHardCoderJNI.hcSNSUserScrollTimeout);
    paramEditor.putLong("KEY_HC_SNS_USER_SCROLL_ACTION", WXHardCoderJNI.hcSNSUserScrollAction);
    paramEditor.putBoolean("KEY_HC_SNS_MSG_SCROLL_ENABLE", WXHardCoderJNI.hcSNSMsgScrollEnable);
    paramEditor.putInt("KEY_HC_SNS_MSG_SCROLL_DELEY", WXHardCoderJNI.hcSNSMsgScrollDelay);
    paramEditor.putInt("KEY_HC_SNS_MSG_SCROLL_CPU", WXHardCoderJNI.hcSNSMsgScrollCPU);
    paramEditor.putInt("KEY_HC_SNS_MSG_SCROLL_IO", WXHardCoderJNI.hcSNSMsgScrollIO);
    paramEditor.putBoolean("KEY_HC_SNS_MSG_SCROLL_THR", WXHardCoderJNI.hcSNSMsgScrollThr);
    paramEditor.putInt("KEY_HC_SNS_MSG_SCROLL_TIMEOUT", WXHardCoderJNI.hcSNSMsgScrollTimeout);
    paramEditor.putLong("KEY_HC_SNS_MSG_SCROLL_ACTION", WXHardCoderJNI.hcSNSMsgScrollAction);
    paramEditor.putBoolean("KEY_HC_MEDIA_GALLERY_SCROLL_ENABLE", WXHardCoderJNI.hcMediaGalleryScrollEnable);
    paramEditor.putInt("KEY_HC_MEDIA_GALLERY_SCROLL_DELEY", WXHardCoderJNI.hcMediaGalleryScrollDelay);
    paramEditor.putInt("KEY_HC_MEDIA_GALLERY_SCROLL_CPU", WXHardCoderJNI.hcMediaGalleryScrollCPU);
    paramEditor.putInt("KEY_HC_MEDIA_GALLERY_SCROLL_IO", WXHardCoderJNI.hcMediaGalleryScrollIO);
    paramEditor.putBoolean("KEY_HC_MEDIA_GALLERY_SCROLL_THR", WXHardCoderJNI.hcMediaGalleryScrollThr);
    paramEditor.putInt("KEY_HC_MEDIA_GALLERY_SCROLL_TIMEOUT", WXHardCoderJNI.hcMediaGalleryScrollTimeout);
    paramEditor.putLong("KEY_HC_MEDIA_GALLERY_SCROLL_ACTION", WXHardCoderJNI.hcMediaGalleryScrollAction);
    paramEditor.putBoolean("KEY_HCALBUM_SCROLL_ENABLE", WXHardCoderJNI.hcAlbumScrollEnable);
    paramEditor.putInt("KEY_HC_ALBUM_SCROLL_DELEY", WXHardCoderJNI.hcAlbumScrollDelay);
    paramEditor.putInt("KEY_HC_ALBUM_SCROLL_CPU", WXHardCoderJNI.hcAlbumScrollCPU);
    paramEditor.putInt("KEY_HC_ALBUM_SCROLL_IO", WXHardCoderJNI.hcAlbumScrollIO);
    paramEditor.putBoolean("KEY_HC_ALBUM_SCROLL_THR", WXHardCoderJNI.hcAlbumScrollThr);
    paramEditor.putInt("KEY_HC_ALBUM_SCROLL_TIMEOUT", WXHardCoderJNI.hcAlbumScrollTimeout);
    paramEditor.putLong("KEY_HC_ALBUM_SCROLL_ACTION", WXHardCoderJNI.hcAlbumScrollAction);
    paramEditor.apply();
    AppMethodBeat.o(39068);
  }
  
  private static String n(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39069);
    String str1 = LocaleUtil.loadApplicationLanguageSettings(paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), paramContext);
    String str2 = LocaleUtil.getApplicationLanguage();
    if ((!str1.equalsIgnoreCase("zh_CN")) && ((!str1.equalsIgnoreCase("language_default")) || (!"zh_CN".equalsIgnoreCase(str2))))
    {
      paramContext = DateFormat.getTimeInstance(3, LocaleUtil.transLanguageToLocale(str1)).format(new Time(paramInt1, paramInt2, 0));
      AppMethodBeat.o(39069);
      return paramContext;
    }
    if (paramInt1 > 12) {}
    for (int i = paramInt1 - 12;; i = paramInt1)
    {
      paramContext = f.A(paramContext, paramInt1 * 3600000L + paramInt2 * 60000L) + String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(39069);
      return paramContext;
    }
  }
  
  public int getLayoutId()
  {
    return R.i.gku;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39065);
    super.onCreate(paramBundle);
    setMMTitle(R.l.settings_hardcoder);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(39059);
        HardCoderSettingUI.this.finish();
        AppMethodBeat.o(39059);
        return true;
      }
    });
    paramBundle = getContext().getSharedPreferences("hardcoder_setting", 0);
    if (!paramBundle.contains("KEY_HC_ENABLE")) {
      b(paramBundle.edit().putBoolean("KEY_HC_ENABLE", true));
    }
    this.afFu = ((CheckBox)findViewById(R.h.fAV));
    this.afFu.setChecked(WXHardCoderJNI.getDebug());
    this.afFs = ((CheckBox)findViewById(R.h.fBb));
    this.afFs.setChecked(WXHardCoderJNI.getEnable());
    this.afFt = ((EditText)findViewById(R.h.fUW));
    this.afFt.setText(WXHardCoderJNI.hcRetryInterval);
    this.afFv = ((CheckBox)findViewById(R.h.fAT));
    this.afFw = ((CheckBox)findViewById(R.h.fAX));
    this.afFw.setChecked(WXHardCoderJNI.hcTimeLimit);
    this.afFx = ((TextView)findViewById(R.h.ftu));
    this.Awy = ((TextView)findViewById(R.h.end_time));
    this.afFx.setText(n(this, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin));
    this.Awy.setText(n(this, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcEndTimeMin));
    this.afFx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39060);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/tools/HardCoderSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        HardCoderSettingUI.a(HardCoderSettingUI.this, true);
        HardCoderSettingUI.this.showDialog(1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/HardCoderSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(39060);
      }
    });
    this.Awy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39061);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/tools/HardCoderSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        HardCoderSettingUI.a(HardCoderSettingUI.this, false);
        HardCoderSettingUI.this.showDialog(1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/HardCoderSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(39061);
      }
    });
    this.afFy = ((CheckBox)findViewById(R.h.fAR));
    this.afFy.setChecked(WXHardCoderJNI.hcBootEnable);
    this.afFz = ((EditText)findViewById(R.h.fED));
    this.afFz.setText(WXHardCoderJNI.hcBootDelay);
    this.afFA = ((EditText)findViewById(R.h.fZF));
    this.afFA.setText(WXHardCoderJNI.hcBootTimeout);
    this.afFA.setSelection(this.afFA.getText().length());
    this.afFB = ((EditText)findViewById(R.h.fpY));
    this.afFB.setText(WXHardCoderJNI.hcBootAction);
    this.afFC = ((Spinner)findViewById(R.h.fDR));
    this.afFC.setSelection(WXHardCoderJNI.hcBootCPU);
    this.afFD = ((Spinner)findViewById(R.h.fLb));
    this.afFD.setSelection(WXHardCoderJNI.hcBootIO);
    this.afFE = ((CheckBox)findViewById(R.h.fZi));
    this.afFE.setChecked(WXHardCoderJNI.hcBootThr);
    this.afFF = ((CheckBox)findViewById(R.h.fAY));
    this.afFF.setChecked(WXHardCoderJNI.hcEnterChattingEnable);
    this.afFG = ((EditText)findViewById(R.h.fEH));
    this.afFG.setText(WXHardCoderJNI.hcEnterChattingDelay);
    this.afFH = ((EditText)findViewById(R.h.fZJ));
    this.afFH.setText(WXHardCoderJNI.hcEnterChattingTimeout);
    this.afFH.setSelection(this.afFH.getText().length());
    this.afFI = ((EditText)findViewById(R.h.fqc));
    this.afFI.setText(WXHardCoderJNI.hcEnterChattingAction);
    this.afFJ = ((Spinner)findViewById(R.h.fDU));
    this.afFJ.setSelection(WXHardCoderJNI.hcEnterChattingCPU);
    this.afFK = ((Spinner)findViewById(R.h.fLe));
    this.afFK.setSelection(WXHardCoderJNI.hcEnterChattingIO);
    this.afFL = ((CheckBox)findViewById(R.h.fZl));
    this.afFL.setChecked(WXHardCoderJNI.hcEnterChattingThr);
    this.afFM = ((CheckBox)findViewById(R.h.fBd));
    this.afFM.setChecked(WXHardCoderJNI.hcQuitChattingEnable);
    this.afFN = ((EditText)findViewById(R.h.fEL));
    this.afFN.setText(WXHardCoderJNI.hcQuitChattingDelay);
    this.afFO = ((EditText)findViewById(R.h.fZN));
    this.afFO.setText(WXHardCoderJNI.hcQuitChattingTimeout);
    this.afFO.setSelection(this.afFO.getText().length());
    this.afFP = ((EditText)findViewById(R.h.fqg));
    this.afFP.setText(WXHardCoderJNI.hcQuitChattingAction);
    this.afFQ = ((Spinner)findViewById(R.h.fDY));
    this.afFQ.setSelection(WXHardCoderJNI.hcQuitChattingCPU);
    this.afFR = ((Spinner)findViewById(R.h.fLi));
    this.afFR.setSelection(WXHardCoderJNI.hcQuitChattingIO);
    this.afFS = ((CheckBox)findViewById(R.h.fZp));
    this.afFS.setChecked(WXHardCoderJNI.hcQuitChattingThr);
    this.afFT = ((CheckBox)findViewById(R.h.fBf));
    this.afFT.setChecked(WXHardCoderJNI.hcSendMsgEnable);
    this.afFU = ((EditText)findViewById(R.h.fEN));
    this.afFU.setText(WXHardCoderJNI.hcSendMsgDelay);
    this.afFV = ((EditText)findViewById(R.h.fZP));
    this.afFV.setText(WXHardCoderJNI.hcSendMsgTimeout);
    this.afFV.setSelection(this.afFV.getText().length());
    this.afFW = ((EditText)findViewById(R.h.fqi));
    this.afFW.setText(WXHardCoderJNI.hcSendMsgAction);
    this.afFX = ((Spinner)findViewById(R.h.fEa));
    this.afFX.setSelection(WXHardCoderJNI.hcSendMsgCPU);
    this.afFY = ((Spinner)findViewById(R.h.fLk));
    this.afFY.setSelection(WXHardCoderJNI.hcSendMsgIO);
    this.afFZ = ((CheckBox)findViewById(R.h.fZr));
    this.afFZ.setChecked(WXHardCoderJNI.hcSendMsgThr);
    this.afGa = ((CheckBox)findViewById(R.h.fBg));
    this.afGa.setChecked(WXHardCoderJNI.hcSendPicMsgEnable);
    this.afGb = ((EditText)findViewById(R.h.fEO));
    this.afGb.setText(WXHardCoderJNI.hcSendPicMsgDelay);
    this.afGc = ((EditText)findViewById(R.h.fZQ));
    this.afGc.setText(WXHardCoderJNI.hcSendPicMsgTimeout);
    this.afGc.setSelection(this.afGc.getText().length());
    this.afGd = ((EditText)findViewById(R.h.fqj));
    this.afGd.setText(WXHardCoderJNI.hcSendPicMsgAction);
    this.afGe = ((Spinner)findViewById(R.h.fEb));
    this.afGe.setSelection(WXHardCoderJNI.hcSendPicMsgCPU);
    this.afGf = ((Spinner)findViewById(R.h.fLl));
    this.afGf.setSelection(WXHardCoderJNI.hcSendPicMsgIO);
    this.afGg = ((CheckBox)findViewById(R.h.fZs));
    this.afGg.setChecked(WXHardCoderJNI.hcSendPicMsgThr);
    this.afGh = ((CheckBox)findViewById(R.h.fBe));
    this.afGh.setChecked(WXHardCoderJNI.hcReceiveMsgEnable);
    this.afGi = ((EditText)findViewById(R.h.fEM));
    this.afGi.setText(WXHardCoderJNI.hcReceiveMsgDelay);
    this.afGj = ((EditText)findViewById(R.h.fZO));
    this.afGj.setText(WXHardCoderJNI.hcReceiveMsgTimeout);
    this.afGj.setSelection(this.afGj.getText().length());
    this.afGk = ((EditText)findViewById(R.h.fqh));
    this.afGk.setText(WXHardCoderJNI.hcReceiveMsgAction);
    this.afGl = ((Spinner)findViewById(R.h.fDZ));
    this.afGl.setSelection(WXHardCoderJNI.hcReceiveMsgCPU);
    this.afGm = ((Spinner)findViewById(R.h.fLj));
    this.afGm.setSelection(WXHardCoderJNI.hcReceiveMsgIO);
    this.afGn = ((CheckBox)findViewById(R.h.fZq));
    this.afGn.setChecked(WXHardCoderJNI.hcReceiveMsgThr);
    this.afGo = ((CheckBox)findViewById(R.h.fBl));
    this.afGo.setChecked(WXHardCoderJNI.hcUpdateChatroomEnable);
    this.afGp = ((EditText)findViewById(R.h.fES));
    this.afGp.setText(WXHardCoderJNI.hcUpdateChatroomDelay);
    this.afGq = ((EditText)findViewById(R.h.fZU));
    this.afGq.setText(WXHardCoderJNI.hcUpdateChatroomTimeout);
    this.afGq.setSelection(this.afGq.getText().length());
    this.afGr = ((EditText)findViewById(R.h.fqn));
    this.afGr.setText(WXHardCoderJNI.hcUpdateChatroomAction);
    this.afGs = ((Spinner)findViewById(R.h.fEf));
    this.afGs.setSelection(WXHardCoderJNI.hcUpdateChatroomCPU);
    this.afGt = ((Spinner)findViewById(R.h.fLp));
    this.afGt.setSelection(WXHardCoderJNI.hcUpdateChatroomIO);
    this.afGu = ((CheckBox)findViewById(R.h.fZw));
    this.afGu.setChecked(WXHardCoderJNI.hcUpdateChatroomThr);
    this.afGv = ((EditText)findViewById(R.h.gbn));
    this.afGv.setText(WXHardCoderJNI.hcUpdateChatroomMemberCount);
    this.afGw = ((CheckBox)findViewById(R.h.fAU));
    this.afGw.setChecked(WXHardCoderJNI.hcDBEnable);
    this.afGx = ((EditText)findViewById(R.h.fEE));
    this.afGx.setText(WXHardCoderJNI.hcDBDelayQuery);
    this.afGy = ((EditText)findViewById(R.h.fEF));
    this.afGy.setText(WXHardCoderJNI.hcDBDelayWrite);
    this.afGz = ((EditText)findViewById(R.h.fZG));
    this.afGz.setText(WXHardCoderJNI.hcDBTimeout);
    this.afGA = ((EditText)findViewById(R.h.fZH));
    this.afGA.setText(WXHardCoderJNI.hcDBTimeoutBusy);
    this.afGB = ((EditText)findViewById(R.h.fpZ));
    this.afGB.setText(WXHardCoderJNI.hcDBActionQuery);
    this.afGC = ((EditText)findViewById(R.h.fqa));
    this.afGC.setText(WXHardCoderJNI.hcDBActionWrite);
    this.afGD = ((Spinner)findViewById(R.h.fDS));
    this.afGD.setSelection(WXHardCoderJNI.hcDBCPU);
    this.afGE = ((Spinner)findViewById(R.h.fLc));
    this.afGE.setSelection(WXHardCoderJNI.hcDBIO);
    this.afGF = ((CheckBox)findViewById(R.h.fZj));
    this.afGF.setChecked(WXHardCoderJNI.hcDBThr);
    this.afGG = ((CheckBox)findViewById(R.h.fBm));
    this.afGG.setChecked(WXHardCoderJNI.hcEncodeVideoEnable);
    this.afGH = ((EditText)findViewById(R.h.fET));
    this.afGH.setText(WXHardCoderJNI.hcEncodeVideoDelay);
    this.afGI = ((EditText)findViewById(R.h.fZV));
    this.afGI.setText(WXHardCoderJNI.hcEncodeVideoTimeout);
    this.afGJ = ((EditText)findViewById(R.h.fqo));
    this.afGJ.setText(WXHardCoderJNI.hcEncodeVideoAction);
    this.afGK = ((Spinner)findViewById(R.h.fEg));
    this.afGK.setSelection(WXHardCoderJNI.hcEncodeVideoCPU);
    this.afGL = ((Spinner)findViewById(R.h.fLq));
    this.afGL.setSelection(WXHardCoderJNI.hcEncodeVideoIO);
    this.afGM = ((CheckBox)findViewById(R.h.fZx));
    this.afGM.setChecked(WXHardCoderJNI.hcEncodeVideoThr);
    this.afGN = ((CheckBox)findViewById(R.h.fAW));
    this.afGN.setChecked(WXHardCoderJNI.hcDecodePicEnable);
    this.afGO = ((EditText)findViewById(R.h.fEG));
    this.afGO.setText(WXHardCoderJNI.hcDecodePicDelay);
    this.afGP = ((EditText)findViewById(R.h.fZI));
    this.afGP.setText(WXHardCoderJNI.hcDecodePicTimeout);
    this.afGQ = ((EditText)findViewById(R.h.fqb));
    this.afGQ.setText(WXHardCoderJNI.hcDecodePicAction);
    this.afGR = ((Spinner)findViewById(R.h.fDT));
    this.afGR.setSelection(WXHardCoderJNI.hcDecodePicCPU);
    this.afGS = ((Spinner)findViewById(R.h.fLd));
    this.afGS.setSelection(WXHardCoderJNI.hcDecodePicIO);
    this.afGT = ((CheckBox)findViewById(R.h.fZk));
    this.afGT.setChecked(WXHardCoderJNI.hcDecodePicThr);
    this.afGU = ((CheckBox)findViewById(R.h.fAZ));
    this.afGU.setChecked(WXHardCoderJNI.hcGifEnable);
    this.afGV = ((EditText)findViewById(R.h.fEI));
    this.afGV.setText(WXHardCoderJNI.hcGifDelay);
    this.afGW = ((EditText)findViewById(R.h.fZK));
    this.afGW.setText(WXHardCoderJNI.hcGifTimeout);
    this.afGX = ((EditText)findViewById(R.h.fqd));
    this.afGX.setText(WXHardCoderJNI.hcGifAction);
    this.afGY = ((Spinner)findViewById(R.h.fDV));
    this.afGY.setSelection(WXHardCoderJNI.hcGifCPU);
    this.afGZ = ((Spinner)findViewById(R.h.fLf));
    this.afGZ.setSelection(WXHardCoderJNI.hcGifIO);
    this.afHa = ((CheckBox)findViewById(R.h.fZm));
    this.afHa.setChecked(WXHardCoderJNI.hcGifThr);
    this.afHb = ((CheckBox)findViewById(R.h.fBa));
    this.afHb.setChecked(WXHardCoderJNI.hcGifFrameEnable);
    this.afHc = ((EditText)findViewById(R.h.fEJ));
    this.afHc.setText(WXHardCoderJNI.hcGifFrameDelay);
    this.afHd = ((EditText)findViewById(R.h.fZL));
    this.afHd.setText(WXHardCoderJNI.hcGifFrameTimeout);
    this.afHe = ((EditText)findViewById(R.h.fqe));
    this.afHe.setText(WXHardCoderJNI.hcGifFrameAction);
    this.afHf = ((Spinner)findViewById(R.h.fDW));
    this.afHf.setSelection(WXHardCoderJNI.hcGifFrameCPU);
    this.afHg = ((Spinner)findViewById(R.h.fLg));
    this.afHg.setSelection(WXHardCoderJNI.hcGifFrameIO);
    this.afHh = ((CheckBox)findViewById(R.h.fZn));
    this.afHh.setChecked(WXHardCoderJNI.hcGifFrameThr);
    this.afHi = ((CheckBox)findViewById(R.h.fBi));
    this.afHi.setChecked(WXHardCoderJNI.hcSNSScrollEnable);
    this.afHj = ((EditText)findViewById(R.h.fEQ));
    this.afHj.setText(WXHardCoderJNI.hcSNSScrollDelay);
    this.afHk = ((EditText)findViewById(R.h.fZS));
    this.afHk.setText(WXHardCoderJNI.hcSNSScrollTimeout);
    this.afHl = ((EditText)findViewById(R.h.fql));
    this.afHl.setText(WXHardCoderJNI.hcSNSScrollAction);
    this.afHm = ((Spinner)findViewById(R.h.fEd));
    this.afHm.setSelection(WXHardCoderJNI.hcSNSScrollCPU);
    this.afHn = ((Spinner)findViewById(R.h.fLn));
    this.afHn.setSelection(WXHardCoderJNI.hcSNSScrollIO);
    this.afHo = ((CheckBox)findViewById(R.h.fZu));
    this.afHo.setChecked(WXHardCoderJNI.hcSNSScrollThr);
    this.afHp = ((CheckBox)findViewById(R.h.fBj));
    this.afHp.setChecked(WXHardCoderJNI.hcSNSUserScrollEnable);
    this.afHq = ((EditText)findViewById(R.h.fER));
    this.afHq.setText(WXHardCoderJNI.hcSNSUserScrollDelay);
    this.afHr = ((EditText)findViewById(R.h.fZT));
    this.afHr.setText(WXHardCoderJNI.hcSNSUserScrollTimeout);
    this.afHs = ((EditText)findViewById(R.h.fqm));
    this.afHs.setText(WXHardCoderJNI.hcSNSUserScrollAction);
    this.afHt = ((Spinner)findViewById(R.h.fEe));
    this.afHt.setSelection(WXHardCoderJNI.hcSNSUserScrollCPU);
    this.afHu = ((Spinner)findViewById(R.h.fLo));
    this.afHu.setSelection(WXHardCoderJNI.hcSNSUserScrollIO);
    this.afHv = ((CheckBox)findViewById(R.h.fZv));
    this.afHv.setChecked(WXHardCoderJNI.hcSNSUserScrollThr);
    this.afHw = ((CheckBox)findViewById(R.h.fBh));
    this.afHw.setChecked(WXHardCoderJNI.hcSNSMsgScrollEnable);
    this.afHx = ((EditText)findViewById(R.h.fEP));
    this.afHx.setText(WXHardCoderJNI.hcSNSMsgScrollDelay);
    this.afHy = ((EditText)findViewById(R.h.fZR));
    this.afHy.setText(WXHardCoderJNI.hcSNSMsgScrollTimeout);
    this.afHz = ((EditText)findViewById(R.h.fqk));
    this.afHz.setText(WXHardCoderJNI.hcSNSMsgScrollAction);
    this.afHA = ((Spinner)findViewById(R.h.fEc));
    this.afHA.setSelection(WXHardCoderJNI.hcSNSMsgScrollCPU);
    this.afHB = ((Spinner)findViewById(R.h.fLm));
    this.afHB.setSelection(WXHardCoderJNI.hcSNSMsgScrollIO);
    this.afHC = ((CheckBox)findViewById(R.h.fZt));
    this.afHC.setChecked(WXHardCoderJNI.hcSNSMsgScrollThr);
    this.afHD = ((CheckBox)findViewById(R.h.fBc));
    this.afHD.setChecked(WXHardCoderJNI.hcMediaGalleryScrollEnable);
    this.afHE = ((EditText)findViewById(R.h.fEK));
    this.afHE.setText(WXHardCoderJNI.hcMediaGalleryScrollDelay);
    this.afHF = ((EditText)findViewById(R.h.fZM));
    this.afHF.setText(WXHardCoderJNI.hcMediaGalleryScrollTimeout);
    this.afHG = ((EditText)findViewById(R.h.fqf));
    this.afHG.setText(WXHardCoderJNI.hcMediaGalleryScrollAction);
    this.afHH = ((Spinner)findViewById(R.h.fDX));
    this.afHH.setSelection(WXHardCoderJNI.hcMediaGalleryScrollCPU);
    this.afHI = ((Spinner)findViewById(R.h.fLh));
    this.afHI.setSelection(WXHardCoderJNI.hcMediaGalleryScrollIO);
    this.afHJ = ((CheckBox)findViewById(R.h.fZo));
    this.afHJ.setChecked(WXHardCoderJNI.hcMediaGalleryScrollThr);
    this.afHK = ((CheckBox)findViewById(R.h.fAP));
    this.afHK.setChecked(WXHardCoderJNI.hcAlbumScrollEnable);
    this.afHL = ((EditText)findViewById(R.h.fEB));
    this.afHL.setText(WXHardCoderJNI.hcAlbumScrollDelay);
    this.afHM = ((EditText)findViewById(R.h.fZD));
    this.afHM.setText(WXHardCoderJNI.hcAlbumScrollTimeout);
    this.afHN = ((EditText)findViewById(R.h.fpW));
    this.afHN.setText(WXHardCoderJNI.hcAlbumScrollAction);
    this.afHO = ((Spinner)findViewById(R.h.fDP));
    this.afHO.setSelection(WXHardCoderJNI.hcAlbumScrollCPU);
    this.afHP = ((Spinner)findViewById(R.h.fKZ));
    this.afHP.setSelection(WXHardCoderJNI.hcAlbumScrollIO);
    this.afHQ = ((CheckBox)findViewById(R.h.fZg));
    this.afHQ.setChecked(WXHardCoderJNI.hcAlbumScrollThr);
    this.afHR = ((CheckBox)findViewById(R.h.fAQ));
    this.afHR.setChecked(WXHardCoderJNI.hcBizEnable);
    this.afHS = ((EditText)findViewById(R.h.fEC));
    this.afHS.setText(WXHardCoderJNI.hcBizDelay);
    this.afHT = ((EditText)findViewById(R.h.fZE));
    this.afHT.setText(WXHardCoderJNI.hcBizTimeout);
    this.afHU = ((EditText)findViewById(R.h.fpX));
    this.afHU.setText(WXHardCoderJNI.hcBizAction);
    this.afHV = ((Spinner)findViewById(R.h.fDQ));
    this.afHV.setSelection(WXHardCoderJNI.hcBizCPU);
    this.afHW = ((Spinner)findViewById(R.h.fLa));
    this.afHW.setSelection(WXHardCoderJNI.hcBizIO);
    this.afHX = ((CheckBox)findViewById(R.h.fZh));
    this.afHX.setChecked(WXHardCoderJNI.hcBizThr);
    this.afFs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39062);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/tools/HardCoderSettingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        boolean bool = HardCoderSettingUI.a(HardCoderSettingUI.this).isChecked();
        HardCoderSettingUI.b(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.c(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.d(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.e(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.f(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.g(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.h(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.i(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.j(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.k(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.l(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.m(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.n(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.o(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.p(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.q(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.r(HardCoderSettingUI.this).setChecked(bool);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/HardCoderSettingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(39062);
      }
    });
    AppMethodBeat.o(39065);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(39066);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(39066);
      return null;
    }
    if (this.Prz)
    {
      localTimePickerDialog = new TimePickerDialog(getContext(), this.PrA, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin, false);
      AppMethodBeat.o(39066);
      return localTimePickerDialog;
    }
    TimePickerDialog localTimePickerDialog = new TimePickerDialog(getContext(), this.PrA, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcBeginTimeMin, false);
    AppMethodBeat.o(39066);
    return localTimePickerDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39067);
    Log.i("HardCoderSettingUI", "save");
    if ((this.afFs.isChecked()) && (!WXHardCoderJNI.getEnable()))
    {
      WXHardCoderJNI.setHcEnable(this.afFs.isChecked());
      WXHardCoderJNI.initHardCoder(com.tencent.mm.plugin.hardcoder.a.fKh(), com.tencent.mm.plugin.hardcoder.a.fKh(), null);
    }
    WXHardCoderJNI.setDebug(this.afFu.isChecked());
    WXHardCoderJNI.setHcEnable(this.afFs.isChecked());
    WXHardCoderJNI.hcRetryInterval = Util.getInt(this.afFt.getText().toString(), WXHardCoderJNI.hcRetryInterval);
    if (WXHardCoderJNI.isCheckEnv())
    {
      WXHardCoderJNI.setDebug(WXHardCoderJNI.getDebug());
      WXHardCoderJNI.setHcEnable(WXHardCoderJNI.getEnable());
      WXHardCoderJNI.setRetryConnectInterval(WXHardCoderJNI.hcRetryInterval);
    }
    WXHardCoderJNI.hcTimeLimit = this.afFw.isChecked();
    WXHardCoderJNI.hcBootEnable = this.afFy.isChecked();
    WXHardCoderJNI.hcBootDelay = Util.getInt(this.afFz.getText().toString(), WXHardCoderJNI.hcBootDelay);
    WXHardCoderJNI.hcBootCPU = this.afFC.getSelectedItemPosition();
    WXHardCoderJNI.hcBootIO = this.afFD.getSelectedItemPosition();
    WXHardCoderJNI.hcBootThr = this.afFE.isChecked();
    WXHardCoderJNI.hcBootTimeout = Util.getInt(this.afFA.getText().toString(), WXHardCoderJNI.hcBootTimeout);
    WXHardCoderJNI.hcBootAction = Util.getLong(this.afFB.getText().toString(), WXHardCoderJNI.hcBootAction);
    WXHardCoderJNI.hcEnterChattingEnable = this.afFF.isChecked();
    WXHardCoderJNI.hcEnterChattingDelay = Util.getInt(this.afFG.getText().toString(), WXHardCoderJNI.hcEnterChattingDelay);
    WXHardCoderJNI.hcEnterChattingCPU = this.afFJ.getSelectedItemPosition();
    WXHardCoderJNI.hcEnterChattingIO = this.afFK.getSelectedItemPosition();
    WXHardCoderJNI.hcEnterChattingThr = this.afFL.isChecked();
    WXHardCoderJNI.hcEnterChattingTimeout = Util.getInt(this.afFH.getText().toString(), WXHardCoderJNI.hcEnterChattingTimeout);
    WXHardCoderJNI.hcEnterChattingAction = Util.getLong(this.afFI.getText().toString(), WXHardCoderJNI.hcEnterChattingAction);
    WXHardCoderJNI.hcQuitChattingEnable = this.afFM.isChecked();
    WXHardCoderJNI.hcQuitChattingDelay = Util.getInt(this.afFN.getText().toString(), WXHardCoderJNI.hcQuitChattingDelay);
    WXHardCoderJNI.hcQuitChattingCPU = this.afFQ.getSelectedItemPosition();
    WXHardCoderJNI.hcQuitChattingIO = this.afFR.getSelectedItemPosition();
    WXHardCoderJNI.hcQuitChattingThr = this.afFS.isChecked();
    WXHardCoderJNI.hcQuitChattingTimeout = Util.getInt(this.afFO.getText().toString(), WXHardCoderJNI.hcQuitChattingTimeout);
    WXHardCoderJNI.hcQuitChattingAction = Util.getLong(this.afFP.getText().toString(), WXHardCoderJNI.hcQuitChattingAction);
    WXHardCoderJNI.hcSendMsgEnable = this.afFT.isChecked();
    WXHardCoderJNI.hcSendMsgDelay = Util.getInt(this.afFU.getText().toString(), WXHardCoderJNI.hcSendMsgDelay);
    WXHardCoderJNI.hcSendMsgCPU = this.afFX.getSelectedItemPosition();
    WXHardCoderJNI.hcSendMsgIO = this.afFY.getSelectedItemPosition();
    WXHardCoderJNI.hcSendMsgThr = this.afFZ.isChecked();
    WXHardCoderJNI.hcSendMsgTimeout = Util.getInt(this.afFV.getText().toString(), WXHardCoderJNI.hcSendMsgTimeout);
    WXHardCoderJNI.hcSendMsgAction = Util.getLong(this.afFW.getText().toString(), WXHardCoderJNI.hcSendMsgAction);
    WXHardCoderJNI.hcSendPicMsgEnable = this.afGa.isChecked();
    WXHardCoderJNI.hcSendPicMsgDelay = Util.getInt(this.afGb.getText().toString(), WXHardCoderJNI.hcSendPicMsgDelay);
    WXHardCoderJNI.hcSendPicMsgCPU = this.afGe.getSelectedItemPosition();
    WXHardCoderJNI.hcSendPicMsgIO = this.afGf.getSelectedItemPosition();
    WXHardCoderJNI.hcSendPicMsgThr = this.afGg.isChecked();
    WXHardCoderJNI.hcSendPicMsgTimeout = Util.getInt(this.afGc.getText().toString(), WXHardCoderJNI.hcSendPicMsgTimeout);
    WXHardCoderJNI.hcSendPicMsgAction = Util.getLong(this.afGd.getText().toString(), WXHardCoderJNI.hcSendPicMsgAction);
    WXHardCoderJNI.hcReceiveMsgEnable = this.afGh.isChecked();
    WXHardCoderJNI.hcReceiveMsgDelay = Util.getInt(this.afGi.getText().toString(), WXHardCoderJNI.hcReceiveMsgDelay);
    WXHardCoderJNI.hcReceiveMsgCPU = this.afGl.getSelectedItemPosition();
    WXHardCoderJNI.hcReceiveMsgIO = this.afGm.getSelectedItemPosition();
    WXHardCoderJNI.hcReceiveMsgThr = this.afGn.isChecked();
    WXHardCoderJNI.hcReceiveMsgTimeout = Util.getInt(this.afGj.getText().toString(), WXHardCoderJNI.hcReceiveMsgTimeout);
    WXHardCoderJNI.hcReceiveMsgAction = Util.getLong(this.afGk.getText().toString(), WXHardCoderJNI.hcReceiveMsgAction);
    WXHardCoderJNI.hcUpdateChatroomEnable = this.afGo.isChecked();
    WXHardCoderJNI.hcUpdateChatroomDelay = Util.getInt(this.afGp.getText().toString(), WXHardCoderJNI.hcUpdateChatroomDelay);
    WXHardCoderJNI.hcUpdateChatroomCPU = this.afGs.getSelectedItemPosition();
    WXHardCoderJNI.hcUpdateChatroomIO = this.afGt.getSelectedItemPosition();
    WXHardCoderJNI.hcUpdateChatroomThr = this.afGu.isChecked();
    WXHardCoderJNI.hcUpdateChatroomTimeout = Util.getInt(this.afGq.getText().toString(), WXHardCoderJNI.hcUpdateChatroomTimeout);
    WXHardCoderJNI.hcUpdateChatroomAction = Util.getLong(this.afGr.getText().toString(), WXHardCoderJNI.hcUpdateChatroomAction);
    WXHardCoderJNI.hcUpdateChatroomMemberCount = Util.getLong(this.afGv.getText().toString(), WXHardCoderJNI.hcUpdateChatroomMemberCount);
    WXHardCoderJNI.hcDBEnable = this.afGw.isChecked();
    WXHardCoderJNI.hcDBDelayQuery = Util.getInt(this.afGx.getText().toString(), WXHardCoderJNI.hcDBDelayQuery);
    WXHardCoderJNI.hcDBDelayWrite = Util.getInt(this.afGy.getText().toString(), WXHardCoderJNI.hcDBDelayWrite);
    WXHardCoderJNI.hcDBCPU = this.afFC.getSelectedItemPosition();
    WXHardCoderJNI.hcDBIO = this.afFD.getSelectedItemPosition();
    WXHardCoderJNI.hcDBThr = this.afFE.isChecked();
    WXHardCoderJNI.hcDBTimeout = Util.getInt(this.afGz.getText().toString(), WXHardCoderJNI.hcDBTimeout);
    WXHardCoderJNI.hcDBTimeoutBusy = Util.getInt(this.afGA.getText().toString(), WXHardCoderJNI.hcDBTimeoutBusy);
    WXHardCoderJNI.hcDBActionQuery = Util.getLong(this.afGB.getText().toString(), WXHardCoderJNI.hcDBActionQuery);
    WXHardCoderJNI.hcDBActionWrite = Util.getLong(this.afGC.getText().toString(), WXHardCoderJNI.hcDBActionWrite);
    WXHardCoderJNI.hcEncodeVideoEnable = this.afGG.isChecked();
    WXHardCoderJNI.hcEncodeVideoDelay = Util.getInt(this.afGH.getText().toString(), WXHardCoderJNI.hcEncodeVideoDelay);
    WXHardCoderJNI.hcEncodeVideoCPU = this.afGK.getSelectedItemPosition();
    WXHardCoderJNI.hcEncodeVideoIO = this.afGL.getSelectedItemPosition();
    WXHardCoderJNI.hcEncodeVideoThr = this.afGM.isChecked();
    WXHardCoderJNI.hcEncodeVideoTimeout = Util.getInt(this.afGI.getText().toString(), WXHardCoderJNI.hcEncodeVideoTimeout);
    WXHardCoderJNI.hcEncodeVideoAction = Util.getLong(this.afGJ.getText().toString(), WXHardCoderJNI.hcEncodeVideoAction);
    WXHardCoderJNI.hcDecodePicEnable = this.afGN.isChecked();
    WXHardCoderJNI.hcDecodePicDelay = Util.getInt(this.afGO.getText().toString(), WXHardCoderJNI.hcDecodePicDelay);
    WXHardCoderJNI.hcDecodePicCPU = this.afGR.getSelectedItemPosition();
    WXHardCoderJNI.hcDecodePicIO = this.afGS.getSelectedItemPosition();
    WXHardCoderJNI.hcDecodePicThr = this.afGT.isChecked();
    WXHardCoderJNI.hcDecodePicTimeout = Util.getInt(this.afGP.getText().toString(), WXHardCoderJNI.hcDecodePicTimeout);
    WXHardCoderJNI.hcDecodePicAction = Util.getLong(this.afGQ.getText().toString(), WXHardCoderJNI.hcDecodePicAction);
    WXHardCoderJNI.hcGifEnable = this.afGU.isChecked();
    WXHardCoderJNI.hcGifDelay = Util.getInt(this.afGV.getText().toString(), WXHardCoderJNI.hcGifDelay);
    WXHardCoderJNI.hcGifCPU = this.afGY.getSelectedItemPosition();
    WXHardCoderJNI.hcGifIO = this.afGZ.getSelectedItemPosition();
    WXHardCoderJNI.hcGifThr = this.afHa.isChecked();
    WXHardCoderJNI.hcGifTimeout = Util.getInt(this.afGW.getText().toString(), WXHardCoderJNI.hcGifTimeout);
    WXHardCoderJNI.hcGifAction = Util.getLong(this.afGX.getText().toString(), WXHardCoderJNI.hcGifAction);
    WXHardCoderJNI.hcGifFrameEnable = this.afHb.isChecked();
    WXHardCoderJNI.hcGifFrameDelay = Util.getInt(this.afHc.getText().toString(), WXHardCoderJNI.hcGifFrameDelay);
    WXHardCoderJNI.hcGifFrameCPU = this.afHf.getSelectedItemPosition();
    WXHardCoderJNI.hcGifFrameIO = this.afHg.getSelectedItemPosition();
    WXHardCoderJNI.hcGifFrameThr = this.afHh.isChecked();
    WXHardCoderJNI.hcGifFrameTimeout = Util.getInt(this.afHd.getText().toString(), WXHardCoderJNI.hcGifFrameTimeout);
    WXHardCoderJNI.hcGifFrameAction = Util.getLong(this.afHe.getText().toString(), WXHardCoderJNI.hcGifFrameAction);
    WXHardCoderJNI.hcSNSScrollEnable = this.afHi.isChecked();
    WXHardCoderJNI.hcSNSScrollDelay = Util.getInt(this.afHj.getText().toString(), WXHardCoderJNI.hcSNSScrollDelay);
    WXHardCoderJNI.hcSNSScrollCPU = this.afHm.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSScrollIO = this.afHn.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSScrollThr = this.afHo.isChecked();
    WXHardCoderJNI.hcSNSScrollTimeout = Util.getInt(this.afHk.getText().toString(), WXHardCoderJNI.hcSNSScrollTimeout);
    WXHardCoderJNI.hcSNSScrollAction = Util.getLong(this.afHl.getText().toString(), WXHardCoderJNI.hcSNSScrollAction);
    WXHardCoderJNI.hcSNSUserScrollEnable = this.afHp.isChecked();
    WXHardCoderJNI.hcSNSUserScrollDelay = Util.getInt(this.afHq.getText().toString(), WXHardCoderJNI.hcSNSUserScrollDelay);
    WXHardCoderJNI.hcSNSUserScrollCPU = this.afHt.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSUserScrollIO = this.afHu.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSUserScrollThr = this.afHv.isChecked();
    WXHardCoderJNI.hcSNSUserScrollTimeout = Util.getInt(this.afHr.getText().toString(), WXHardCoderJNI.hcSNSUserScrollTimeout);
    WXHardCoderJNI.hcSNSUserScrollAction = Util.getLong(this.afHs.getText().toString(), WXHardCoderJNI.hcSNSUserScrollAction);
    WXHardCoderJNI.hcSNSMsgScrollEnable = this.afHw.isChecked();
    WXHardCoderJNI.hcSNSMsgScrollDelay = Util.getInt(this.afHx.getText().toString(), WXHardCoderJNI.hcSNSMsgScrollDelay);
    WXHardCoderJNI.hcSNSMsgScrollCPU = this.afHA.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSMsgScrollIO = this.afHB.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSMsgScrollThr = this.afHC.isChecked();
    WXHardCoderJNI.hcSNSMsgScrollTimeout = Util.getInt(this.afHy.getText().toString(), WXHardCoderJNI.hcSNSMsgScrollTimeout);
    WXHardCoderJNI.hcSNSMsgScrollAction = Util.getLong(this.afHz.getText().toString(), WXHardCoderJNI.hcSNSMsgScrollAction);
    WXHardCoderJNI.hcMediaGalleryScrollEnable = this.afHD.isChecked();
    WXHardCoderJNI.hcMediaGalleryScrollDelay = Util.getInt(this.afHE.getText().toString(), WXHardCoderJNI.hcMediaGalleryScrollDelay);
    WXHardCoderJNI.hcMediaGalleryScrollCPU = this.afHH.getSelectedItemPosition();
    WXHardCoderJNI.hcMediaGalleryScrollIO = this.afHI.getSelectedItemPosition();
    WXHardCoderJNI.hcMediaGalleryScrollThr = this.afHJ.isChecked();
    WXHardCoderJNI.hcMediaGalleryScrollTimeout = Util.getInt(this.afHF.getText().toString(), WXHardCoderJNI.hcMediaGalleryScrollTimeout);
    WXHardCoderJNI.hcMediaGalleryScrollAction = Util.getLong(this.afHG.getText().toString(), WXHardCoderJNI.hcMediaGalleryScrollAction);
    WXHardCoderJNI.hcAlbumScrollEnable = this.afHK.isChecked();
    WXHardCoderJNI.hcAlbumScrollDelay = Util.getInt(this.afHL.getText().toString(), WXHardCoderJNI.hcAlbumScrollDelay);
    WXHardCoderJNI.hcAlbumScrollCPU = this.afHO.getSelectedItemPosition();
    WXHardCoderJNI.hcAlbumScrollIO = this.afHP.getSelectedItemPosition();
    WXHardCoderJNI.hcAlbumScrollThr = this.afHQ.isChecked();
    WXHardCoderJNI.hcAlbumScrollTimeout = Util.getInt(this.afHM.getText().toString(), WXHardCoderJNI.hcAlbumScrollTimeout);
    WXHardCoderJNI.hcAlbumScrollAction = Util.getLong(this.afHN.getText().toString(), WXHardCoderJNI.hcAlbumScrollAction);
    WXHardCoderJNI.hcBizEnable = this.afHR.isChecked();
    WXHardCoderJNI.hcBizDelay = Util.getInt(this.afHS.getText().toString(), WXHardCoderJNI.hcBizDelay);
    WXHardCoderJNI.hcBizCPU = this.afHV.getSelectedItemPosition();
    WXHardCoderJNI.hcBizIO = this.afHW.getSelectedItemPosition();
    WXHardCoderJNI.hcBizThr = this.afHX.isChecked();
    WXHardCoderJNI.hcBizTimeout = Util.getInt(this.afHT.getText().toString(), WXHardCoderJNI.hcBizTimeout);
    WXHardCoderJNI.hcBizAction = Util.getLong(this.afHU.getText().toString(), WXHardCoderJNI.hcBizAction);
    b(getContext().getSharedPreferences("hardcoder_setting", 0).edit());
    WXHardCoderJNI.reloadSPConfig(WXHardCoderJNI.RELOAD_SCENE_SETTING);
    super.onDestroy();
    AppMethodBeat.o(39067);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ui.tools.HardCoderSettingUI
 * JD-Core Version:    0.7.0.1
 */