package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class VoiceInputBehavior
  extends com.tencent.mm.bx.a
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
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151541);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.cancel);
      paramVarArgs.aR(2, this.send);
      paramVarArgs.aR(3, this.click);
      paramVarArgs.aR(4, this.longClick);
      paramVarArgs.aG(5, this.longClickTime);
      paramVarArgs.aR(6, this.textClick);
      paramVarArgs.aR(7, this.textChangeCount);
      paramVarArgs.aG(8, this.textChangeTime);
      paramVarArgs.aR(9, this.textChangeReturn);
      paramVarArgs.aG(10, this.voiceInputTime);
      paramVarArgs.aR(11, this.fail);
      paramVarArgs.aR(12, this.clear);
      paramVarArgs.aR(13, this.smileIconClick);
      paramVarArgs.aR(14, this.voiceIconClick);
      paramVarArgs.aR(15, this.fullScreenVoiceLongClick);
      paramVarArgs.aG(16, this.fullScreenVoiceLongClickTime);
      paramVarArgs.aR(17, this.showInit);
      paramVarArgs.aG(18, this.initChoose);
      paramVarArgs.aR(19, this.chooseArea);
      paramVarArgs.aR(20, this.chooseCantonese);
      paramVarArgs.aR(21, this.setlanguage);
      paramVarArgs.aR(22, this.setSwitchCantonese);
      paramVarArgs.aR(23, this.setDefaultLanguage);
      AppMethodBeat.o(151541);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.cancel);
      int i = f.a.a.b.b.a.bA(2, this.send);
      int j = f.a.a.b.b.a.bA(3, this.click);
      int k = f.a.a.b.b.a.bA(4, this.longClick);
      int m = f.a.a.b.b.a.q(5, this.longClickTime);
      int n = f.a.a.b.b.a.bA(6, this.textClick);
      int i1 = f.a.a.b.b.a.bA(7, this.textChangeCount);
      int i2 = f.a.a.b.b.a.q(8, this.textChangeTime);
      int i3 = f.a.a.b.b.a.bA(9, this.textChangeReturn);
      int i4 = f.a.a.b.b.a.q(10, this.voiceInputTime);
      int i5 = f.a.a.b.b.a.bA(11, this.fail);
      int i6 = f.a.a.b.b.a.bA(12, this.clear);
      int i7 = f.a.a.b.b.a.bA(13, this.smileIconClick);
      int i8 = f.a.a.b.b.a.bA(14, this.voiceIconClick);
      int i9 = f.a.a.b.b.a.bA(15, this.fullScreenVoiceLongClick);
      int i10 = f.a.a.b.b.a.q(16, this.fullScreenVoiceLongClickTime);
      int i11 = f.a.a.b.b.a.bA(17, this.showInit);
      int i12 = f.a.a.b.b.a.q(18, this.initChoose);
      int i13 = f.a.a.b.b.a.bA(19, this.chooseArea);
      int i14 = f.a.a.b.b.a.bA(20, this.chooseCantonese);
      int i15 = f.a.a.b.b.a.bA(21, this.setlanguage);
      int i16 = f.a.a.b.b.a.bA(22, this.setSwitchCantonese);
      int i17 = f.a.a.b.b.a.bA(23, this.setDefaultLanguage);
      AppMethodBeat.o(151541);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i10 + i11 + i12 + i13 + i14 + i15 + i16 + i17;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(151541);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      VoiceInputBehavior localVoiceInputBehavior = (VoiceInputBehavior)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151541);
        return -1;
      case 1: 
        localVoiceInputBehavior.cancel = locala.KhF.xS();
        AppMethodBeat.o(151541);
        return 0;
      case 2: 
        localVoiceInputBehavior.send = locala.KhF.xS();
        AppMethodBeat.o(151541);
        return 0;
      case 3: 
        localVoiceInputBehavior.click = locala.KhF.xS();
        AppMethodBeat.o(151541);
        return 0;
      case 4: 
        localVoiceInputBehavior.longClick = locala.KhF.xS();
        AppMethodBeat.o(151541);
        return 0;
      case 5: 
        localVoiceInputBehavior.longClickTime = locala.KhF.xT();
        AppMethodBeat.o(151541);
        return 0;
      case 6: 
        localVoiceInputBehavior.textClick = locala.KhF.xS();
        AppMethodBeat.o(151541);
        return 0;
      case 7: 
        localVoiceInputBehavior.textChangeCount = locala.KhF.xS();
        AppMethodBeat.o(151541);
        return 0;
      case 8: 
        localVoiceInputBehavior.textChangeTime = locala.KhF.xT();
        AppMethodBeat.o(151541);
        return 0;
      case 9: 
        localVoiceInputBehavior.textChangeReturn = locala.KhF.xS();
        AppMethodBeat.o(151541);
        return 0;
      case 10: 
        localVoiceInputBehavior.voiceInputTime = locala.KhF.xT();
        AppMethodBeat.o(151541);
        return 0;
      case 11: 
        localVoiceInputBehavior.fail = locala.KhF.xS();
        AppMethodBeat.o(151541);
        return 0;
      case 12: 
        localVoiceInputBehavior.clear = locala.KhF.xS();
        AppMethodBeat.o(151541);
        return 0;
      case 13: 
        localVoiceInputBehavior.smileIconClick = locala.KhF.xS();
        AppMethodBeat.o(151541);
        return 0;
      case 14: 
        localVoiceInputBehavior.voiceIconClick = locala.KhF.xS();
        AppMethodBeat.o(151541);
        return 0;
      case 15: 
        localVoiceInputBehavior.fullScreenVoiceLongClick = locala.KhF.xS();
        AppMethodBeat.o(151541);
        return 0;
      case 16: 
        localVoiceInputBehavior.fullScreenVoiceLongClickTime = locala.KhF.xT();
        AppMethodBeat.o(151541);
        return 0;
      case 17: 
        localVoiceInputBehavior.showInit = locala.KhF.xS();
        AppMethodBeat.o(151541);
        return 0;
      case 18: 
        localVoiceInputBehavior.initChoose = locala.KhF.xT();
        AppMethodBeat.o(151541);
        return 0;
      case 19: 
        localVoiceInputBehavior.chooseArea = locala.KhF.xS();
        AppMethodBeat.o(151541);
        return 0;
      case 20: 
        localVoiceInputBehavior.chooseCantonese = locala.KhF.xS();
        AppMethodBeat.o(151541);
        return 0;
      case 21: 
        localVoiceInputBehavior.setlanguage = locala.KhF.xS();
        AppMethodBeat.o(151541);
        return 0;
      case 22: 
        localVoiceInputBehavior.setSwitchCantonese = locala.KhF.xS();
        AppMethodBeat.o(151541);
        return 0;
      }
      localVoiceInputBehavior.setDefaultLanguage = locala.KhF.xS();
      AppMethodBeat.o(151541);
      return 0;
    }
    AppMethodBeat.o(151541);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior
 * JD-Core Version:    0.7.0.1
 */