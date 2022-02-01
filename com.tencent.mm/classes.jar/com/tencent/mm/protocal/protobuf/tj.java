package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class tj
  extends cpx
{
  public int EnA;
  public String Enn;
  public String Ent;
  public String Enu;
  public int Env;
  public String Enw;
  public String Enx;
  public String Eny;
  public String Enz;
  public int channel;
  public int uiK;
  public String wLo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72437);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ent == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_name");
        AppMethodBeat.o(72437);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Ent != null) {
        paramVarArgs.d(2, this.Ent);
      }
      paramVarArgs.aR(3, this.uiK);
      if (this.Enu != null) {
        paramVarArgs.d(4, this.Enu);
      }
      if (this.wLo != null) {
        paramVarArgs.d(5, this.wLo);
      }
      paramVarArgs.aR(6, this.Env);
      paramVarArgs.aR(7, this.channel);
      if (this.Enw != null) {
        paramVarArgs.d(8, this.Enw);
      }
      if (this.Enn != null) {
        paramVarArgs.d(9, this.Enn);
      }
      if (this.Enx != null) {
        paramVarArgs.d(10, this.Enx);
      }
      if (this.Eny != null) {
        paramVarArgs.d(11, this.Eny);
      }
      if (this.Enz != null) {
        paramVarArgs.d(12, this.Enz);
      }
      paramVarArgs.aR(13, this.EnA);
      AppMethodBeat.o(72437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1030;
      }
    }
    label1030:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ent != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Ent);
      }
      i += f.a.a.b.b.a.bx(3, this.uiK);
      paramInt = i;
      if (this.Enu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Enu);
      }
      i = paramInt;
      if (this.wLo != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.wLo);
      }
      i = i + f.a.a.b.b.a.bx(6, this.Env) + f.a.a.b.b.a.bx(7, this.channel);
      paramInt = i;
      if (this.Enw != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Enw);
      }
      i = paramInt;
      if (this.Enn != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Enn);
      }
      paramInt = i;
      if (this.Enx != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Enx);
      }
      i = paramInt;
      if (this.Eny != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Eny);
      }
      paramInt = i;
      if (this.Enz != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Enz);
      }
      i = f.a.a.b.b.a.bx(13, this.EnA);
      AppMethodBeat.o(72437);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Ent == null)
        {
          paramVarArgs = new b("Not all required fields were included: receiver_name");
          AppMethodBeat.o(72437);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72437);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        tj localtj = (tj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72437);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localtj.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72437);
          return 0;
        case 2: 
          localtj.Ent = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 3: 
          localtj.uiK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72437);
          return 0;
        case 4: 
          localtj.Enu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 5: 
          localtj.wLo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 6: 
          localtj.Env = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72437);
          return 0;
        case 7: 
          localtj.channel = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72437);
          return 0;
        case 8: 
          localtj.Enw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 9: 
          localtj.Enn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 10: 
          localtj.Enx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 11: 
          localtj.Eny = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 12: 
          localtj.Enz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72437);
          return 0;
        }
        localtj.EnA = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(72437);
        return 0;
      }
      AppMethodBeat.o(72437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tj
 * JD-Core Version:    0.7.0.1
 */