package com.tencent.mm.plugin.report.kvdata;

public class VoiceInputBehavior
  extends com.tencent.mm.bv.a
{
  public int cancel;
  public int chooseArea;
  public int chooseCantonese;
  public int clear;
  public int click;
  public int fail;
  public int fullScreenVoiceLongClick;
  public long fullScreenVoiceLongClickTime;
  public long initChoose;
  public int longClick;
  public long longClickTime;
  public int send;
  public int setDefaultLanguage;
  public int setSwitchCantonese;
  public int setlanguage;
  public int showInit;
  public int smileIconClick;
  public int textChangeCount;
  public int textChangeReturn;
  public long textChangeTime;
  public int textClick;
  public int voiceIconClick;
  public long voiceInputTime;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.cancel);
      paramVarArgs.gB(2, this.send);
      paramVarArgs.gB(3, this.click);
      paramVarArgs.gB(4, this.longClick);
      paramVarArgs.Y(5, this.longClickTime);
      paramVarArgs.gB(6, this.textClick);
      paramVarArgs.gB(7, this.textChangeCount);
      paramVarArgs.Y(8, this.textChangeTime);
      paramVarArgs.gB(9, this.textChangeReturn);
      paramVarArgs.Y(10, this.voiceInputTime);
      paramVarArgs.gB(11, this.fail);
      paramVarArgs.gB(12, this.clear);
      paramVarArgs.gB(13, this.smileIconClick);
      paramVarArgs.gB(14, this.voiceIconClick);
      paramVarArgs.gB(15, this.fullScreenVoiceLongClick);
      paramVarArgs.Y(16, this.fullScreenVoiceLongClickTime);
      paramVarArgs.gB(17, this.showInit);
      paramVarArgs.Y(18, this.initChoose);
      paramVarArgs.gB(19, this.chooseArea);
      paramVarArgs.gB(20, this.chooseCantonese);
      paramVarArgs.gB(21, this.setlanguage);
      paramVarArgs.gB(22, this.setSwitchCantonese);
      paramVarArgs.gB(23, this.setDefaultLanguage);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.cancel) + 0 + d.a.a.a.gy(2, this.send) + d.a.a.a.gy(3, this.click) + d.a.a.a.gy(4, this.longClick) + d.a.a.a.X(5, this.longClickTime) + d.a.a.a.gy(6, this.textClick) + d.a.a.a.gy(7, this.textChangeCount) + d.a.a.a.X(8, this.textChangeTime) + d.a.a.a.gy(9, this.textChangeReturn) + d.a.a.a.X(10, this.voiceInputTime) + d.a.a.a.gy(11, this.fail) + d.a.a.a.gy(12, this.clear) + d.a.a.a.gy(13, this.smileIconClick) + d.a.a.a.gy(14, this.voiceIconClick) + d.a.a.a.gy(15, this.fullScreenVoiceLongClick) + d.a.a.a.X(16, this.fullScreenVoiceLongClickTime) + d.a.a.a.gy(17, this.showInit) + d.a.a.a.X(18, this.initChoose) + d.a.a.a.gy(19, this.chooseArea) + d.a.a.a.gy(20, this.chooseCantonese) + d.a.a.a.gy(21, this.setlanguage) + d.a.a.a.gy(22, this.setSwitchCantonese) + d.a.a.a.gy(23, this.setDefaultLanguage);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      VoiceInputBehavior localVoiceInputBehavior = (VoiceInputBehavior)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localVoiceInputBehavior.cancel = locala.xpH.oD();
        return 0;
      case 2: 
        localVoiceInputBehavior.send = locala.xpH.oD();
        return 0;
      case 3: 
        localVoiceInputBehavior.click = locala.xpH.oD();
        return 0;
      case 4: 
        localVoiceInputBehavior.longClick = locala.xpH.oD();
        return 0;
      case 5: 
        localVoiceInputBehavior.longClickTime = locala.xpH.oE();
        return 0;
      case 6: 
        localVoiceInputBehavior.textClick = locala.xpH.oD();
        return 0;
      case 7: 
        localVoiceInputBehavior.textChangeCount = locala.xpH.oD();
        return 0;
      case 8: 
        localVoiceInputBehavior.textChangeTime = locala.xpH.oE();
        return 0;
      case 9: 
        localVoiceInputBehavior.textChangeReturn = locala.xpH.oD();
        return 0;
      case 10: 
        localVoiceInputBehavior.voiceInputTime = locala.xpH.oE();
        return 0;
      case 11: 
        localVoiceInputBehavior.fail = locala.xpH.oD();
        return 0;
      case 12: 
        localVoiceInputBehavior.clear = locala.xpH.oD();
        return 0;
      case 13: 
        localVoiceInputBehavior.smileIconClick = locala.xpH.oD();
        return 0;
      case 14: 
        localVoiceInputBehavior.voiceIconClick = locala.xpH.oD();
        return 0;
      case 15: 
        localVoiceInputBehavior.fullScreenVoiceLongClick = locala.xpH.oD();
        return 0;
      case 16: 
        localVoiceInputBehavior.fullScreenVoiceLongClickTime = locala.xpH.oE();
        return 0;
      case 17: 
        localVoiceInputBehavior.showInit = locala.xpH.oD();
        return 0;
      case 18: 
        localVoiceInputBehavior.initChoose = locala.xpH.oE();
        return 0;
      case 19: 
        localVoiceInputBehavior.chooseArea = locala.xpH.oD();
        return 0;
      case 20: 
        localVoiceInputBehavior.chooseCantonese = locala.xpH.oD();
        return 0;
      case 21: 
        localVoiceInputBehavior.setlanguage = locala.xpH.oD();
        return 0;
      case 22: 
        localVoiceInputBehavior.setSwitchCantonese = locala.xpH.oD();
        return 0;
      }
      localVoiceInputBehavior.setDefaultLanguage = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior
 * JD-Core Version:    0.7.0.1
 */