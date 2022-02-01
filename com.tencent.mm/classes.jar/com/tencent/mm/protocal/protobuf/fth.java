package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fth
  extends erp
{
  public String AttachedText;
  public String AttachedTextColor;
  public int IJG;
  public String LensId;
  public String MD5;
  public boolean abRA;
  public boolean abRv;
  public LinkedList<String> abRw;
  public String abRx;
  
  public fth()
  {
    AppMethodBeat.i(104842);
    this.abRw = new LinkedList();
    AppMethodBeat.o(104842);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104843);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MD5 != null) {
        paramVarArgs.g(2, this.MD5);
      }
      paramVarArgs.di(3, this.abRA);
      paramVarArgs.di(4, this.abRv);
      paramVarArgs.e(5, 1, this.abRw);
      if (this.AttachedText != null) {
        paramVarArgs.g(6, this.AttachedText);
      }
      if (this.abRx != null) {
        paramVarArgs.g(7, this.abRx);
      }
      if (this.LensId != null) {
        paramVarArgs.g(8, this.LensId);
      }
      if (this.AttachedTextColor != null) {
        paramVarArgs.g(9, this.AttachedTextColor);
      }
      paramVarArgs.bS(10, this.IJG);
      AppMethodBeat.o(104843);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label780;
      }
    }
    label780:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.MD5);
      }
      i = i + (i.a.a.b.b.a.ko(3) + 1) + (i.a.a.b.b.a.ko(4) + 1) + i.a.a.a.c(5, 1, this.abRw);
      paramInt = i;
      if (this.AttachedText != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.AttachedText);
      }
      i = paramInt;
      if (this.abRx != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.abRx);
      }
      paramInt = i;
      if (this.LensId != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.LensId);
      }
      i = paramInt;
      if (this.AttachedTextColor != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.AttachedTextColor);
      }
      paramInt = i.a.a.b.b.a.cJ(10, this.IJG);
      AppMethodBeat.o(104843);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abRw.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(104843);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fth localfth = (fth)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104843);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localfth.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(104843);
          return 0;
        case 2: 
          localfth.MD5 = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 3: 
          localfth.abRA = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(104843);
          return 0;
        case 4: 
          localfth.abRv = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(104843);
          return 0;
        case 5: 
          localfth.abRw.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(104843);
          return 0;
        case 6: 
          localfth.AttachedText = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 7: 
          localfth.abRx = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 8: 
          localfth.LensId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 9: 
          localfth.AttachedTextColor = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104843);
          return 0;
        }
        localfth.IJG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(104843);
        return 0;
      }
      AppMethodBeat.o(104843);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fth
 * JD-Core Version:    0.7.0.1
 */