package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class tm
  extends cqk
{
  public String EnC;
  public String EnD;
  public String EnE;
  public LinkedList<Integer> Enb;
  public int End;
  public String Enn;
  public String Ent;
  public String Enw;
  public String Eny;
  public String Enz;
  public int dae;
  public String desc;
  public String oxf;
  public String wKR;
  
  public tm()
  {
    AppMethodBeat.i(72440);
    this.Enb = new LinkedList();
    AppMethodBeat.o(72440);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72441);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72441);
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
      if (this.Ent != null) {
        paramVarArgs.d(4, this.Ent);
      }
      paramVarArgs.e(5, 2, this.Enb);
      if (this.desc != null) {
        paramVarArgs.d(6, this.desc);
      }
      if (this.EnC != null) {
        paramVarArgs.d(7, this.EnC);
      }
      if (this.wKR != null) {
        paramVarArgs.d(8, this.wKR);
      }
      if (this.Enw != null) {
        paramVarArgs.d(9, this.Enw);
      }
      if (this.Eny != null) {
        paramVarArgs.d(10, this.Eny);
      }
      if (this.Enz != null) {
        paramVarArgs.d(11, this.Enz);
      }
      paramVarArgs.aR(12, this.End);
      if (this.Enn != null) {
        paramVarArgs.d(13, this.Enn);
      }
      if (this.EnD != null) {
        paramVarArgs.d(14, this.EnD);
      }
      if (this.EnE != null) {
        paramVarArgs.d(15, this.EnE);
      }
      AppMethodBeat.o(72441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1189;
      }
    }
    label1189:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dae);
      paramInt = i;
      if (this.oxf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oxf);
      }
      i = paramInt;
      if (this.Ent != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Ent);
      }
      i += f.a.a.a.c(5, 2, this.Enb);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.desc);
      }
      i = paramInt;
      if (this.EnC != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EnC);
      }
      paramInt = i;
      if (this.wKR != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.wKR);
      }
      i = paramInt;
      if (this.Enw != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Enw);
      }
      paramInt = i;
      if (this.Eny != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Eny);
      }
      i = paramInt;
      if (this.Enz != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Enz);
      }
      i += f.a.a.b.b.a.bx(12, this.End);
      paramInt = i;
      if (this.Enn != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.Enn);
      }
      i = paramInt;
      if (this.EnD != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.EnD);
      }
      paramInt = i;
      if (this.EnE != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.EnE);
      }
      AppMethodBeat.o(72441);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Enb.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72441);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        tm localtm = (tm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72441);
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
            localtm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72441);
          return 0;
        case 2: 
          localtm.dae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72441);
          return 0;
        case 3: 
          localtm.oxf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 4: 
          localtm.Ent = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 5: 
          localtm.Enb.add(Integer.valueOf(((f.a.a.a.a)localObject1).LVo.xF()));
          AppMethodBeat.o(72441);
          return 0;
        case 6: 
          localtm.desc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 7: 
          localtm.EnC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 8: 
          localtm.wKR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 9: 
          localtm.Enw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 10: 
          localtm.Eny = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 11: 
          localtm.Enz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 12: 
          localtm.End = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72441);
          return 0;
        case 13: 
          localtm.Enn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72441);
          return 0;
        case 14: 
          localtm.EnD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72441);
          return 0;
        }
        localtm.EnE = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72441);
        return 0;
      }
      AppMethodBeat.o(72441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tm
 * JD-Core Version:    0.7.0.1
 */