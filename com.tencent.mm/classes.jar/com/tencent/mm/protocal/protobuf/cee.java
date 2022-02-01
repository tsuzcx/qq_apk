package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cee
  extends cqk
{
  public String BAu;
  public dvo FsK;
  public dvl FsL;
  public dvh FsM;
  public dvm FsN;
  public boolean FsO;
  public LinkedList<String> FsP;
  public dvj FsQ;
  public int dfm;
  public String dfn;
  public int uAH;
  
  public cee()
  {
    AppMethodBeat.i(91588);
    this.FsP = new LinkedList();
    AppMethodBeat.o(91588);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91589);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91589);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dfm);
      if (this.dfn != null) {
        paramVarArgs.d(3, this.dfn);
      }
      if (this.FsK != null)
      {
        paramVarArgs.ln(4, this.FsK.computeSize());
        this.FsK.writeFields(paramVarArgs);
      }
      if (this.FsL != null)
      {
        paramVarArgs.ln(5, this.FsL.computeSize());
        this.FsL.writeFields(paramVarArgs);
      }
      if (this.FsM != null)
      {
        paramVarArgs.ln(6, this.FsM.computeSize());
        this.FsM.writeFields(paramVarArgs);
      }
      if (this.FsN != null)
      {
        paramVarArgs.ln(7, this.FsN.computeSize());
        this.FsN.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.uAH);
      paramVarArgs.bl(9, this.FsO);
      if (this.BAu != null) {
        paramVarArgs.d(10, this.BAu);
      }
      paramVarArgs.e(11, 1, this.FsP);
      if (this.FsQ != null)
      {
        paramVarArgs.ln(12, this.FsQ.computeSize());
        this.FsQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1450;
      }
    }
    label1450:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dfm);
      paramInt = i;
      if (this.dfn != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dfn);
      }
      i = paramInt;
      if (this.FsK != null) {
        i = paramInt + f.a.a.a.lm(4, this.FsK.computeSize());
      }
      paramInt = i;
      if (this.FsL != null) {
        paramInt = i + f.a.a.a.lm(5, this.FsL.computeSize());
      }
      i = paramInt;
      if (this.FsM != null) {
        i = paramInt + f.a.a.a.lm(6, this.FsM.computeSize());
      }
      paramInt = i;
      if (this.FsN != null) {
        paramInt = i + f.a.a.a.lm(7, this.FsN.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.uAH) + (f.a.a.b.b.a.fK(9) + 1);
      paramInt = i;
      if (this.BAu != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.BAu);
      }
      i = paramInt + f.a.a.a.c(11, 1, this.FsP);
      paramInt = i;
      if (this.FsQ != null) {
        paramInt = i + f.a.a.a.lm(12, this.FsQ.computeSize());
      }
      AppMethodBeat.o(91589);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FsP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91589);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91589);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cee localcee = (cee)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91589);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcee.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 2: 
          localcee.dfm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91589);
          return 0;
        case 3: 
          localcee.dfn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91589);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcee.FsK = ((dvo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcee.FsL = ((dvl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcee.FsM = ((dvh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcee.FsN = ((dvm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 8: 
          localcee.uAH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91589);
          return 0;
        case 9: 
          localcee.FsO = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91589);
          return 0;
        case 10: 
          localcee.BAu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91589);
          return 0;
        case 11: 
          localcee.FsP.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(91589);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dvj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dvj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcee.FsQ = ((dvj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91589);
        return 0;
      }
      AppMethodBeat.o(91589);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cee
 * JD-Core Version:    0.7.0.1
 */