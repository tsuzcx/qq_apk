package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class tk
  extends cqk
{
  public String DQt;
  public String EnB;
  public String Enm;
  public String Enn;
  public String Enp;
  public int dae;
  public String djr;
  public String oxf;
  public int uiK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72438);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72438);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dae);
      if (this.oxf != null) {
        paramVarArgs.d(3, this.oxf);
      }
      if (this.djr != null) {
        paramVarArgs.d(4, this.djr);
      }
      if (this.Enp != null) {
        paramVarArgs.d(5, this.Enp);
      }
      if (this.DQt != null) {
        paramVarArgs.d(6, this.DQt);
      }
      paramVarArgs.aR(7, this.uiK);
      if (this.EnB != null) {
        paramVarArgs.d(8, this.EnB);
      }
      if (this.Enn != null) {
        paramVarArgs.d(9, this.Enn);
      }
      if (this.Enm != null) {
        paramVarArgs.d(10, this.Enm);
      }
      AppMethodBeat.o(72438);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dae);
      paramInt = i;
      if (this.oxf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oxf);
      }
      i = paramInt;
      if (this.djr != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.djr);
      }
      paramInt = i;
      if (this.Enp != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Enp);
      }
      i = paramInt;
      if (this.DQt != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DQt);
      }
      i += f.a.a.b.b.a.bx(7, this.uiK);
      paramInt = i;
      if (this.EnB != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EnB);
      }
      i = paramInt;
      if (this.Enn != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Enn);
      }
      paramInt = i;
      if (this.Enm != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Enm);
      }
      AppMethodBeat.o(72438);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72438);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72438);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        tk localtk = (tk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72438);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localtk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72438);
          return 0;
        case 2: 
          localtk.dae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72438);
          return 0;
        case 3: 
          localtk.oxf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 4: 
          localtk.djr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 5: 
          localtk.Enp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 6: 
          localtk.DQt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 7: 
          localtk.uiK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72438);
          return 0;
        case 8: 
          localtk.EnB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 9: 
          localtk.Enn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72438);
          return 0;
        }
        localtk.Enm = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72438);
        return 0;
      }
      AppMethodBeat.o(72438);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tk
 * JD-Core Version:    0.7.0.1
 */