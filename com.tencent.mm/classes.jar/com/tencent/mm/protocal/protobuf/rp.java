package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rp
  extends com.tencent.mm.bw.a
{
  public dhb DNJ;
  public crj DNL;
  public String DWw;
  public bld EjQ;
  public LinkedList<dhb> EjR;
  public int EjS;
  public int EjT;
  public String cZz;
  public int state;
  public String vwo;
  
  public rp()
  {
    AppMethodBeat.i(91394);
    this.EjR = new LinkedList();
    AppMethodBeat.o(91394);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91395);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EjQ != null)
      {
        paramVarArgs.ln(1, this.EjQ.computeSize());
        this.EjQ.writeFields(paramVarArgs);
      }
      if (this.DNJ != null)
      {
        paramVarArgs.ln(2, this.DNJ.computeSize());
        this.DNJ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.EjR);
      if (this.vwo != null) {
        paramVarArgs.d(4, this.vwo);
      }
      if (this.cZz != null) {
        paramVarArgs.d(5, this.cZz);
      }
      if (this.DNL != null)
      {
        paramVarArgs.ln(6, this.DNL.computeSize());
        this.DNL.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.state);
      paramVarArgs.aR(8, this.EjS);
      paramVarArgs.aR(9, this.EjT);
      if (this.DWw != null) {
        paramVarArgs.d(10, this.DWw);
      }
      AppMethodBeat.o(91395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EjQ == null) {
        break label1078;
      }
    }
    label1078:
    for (paramInt = f.a.a.a.lm(1, this.EjQ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DNJ != null) {
        i = paramInt + f.a.a.a.lm(2, this.DNJ.computeSize());
      }
      i += f.a.a.a.c(3, 8, this.EjR);
      paramInt = i;
      if (this.vwo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.vwo);
      }
      i = paramInt;
      if (this.cZz != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.cZz);
      }
      paramInt = i;
      if (this.DNL != null) {
        paramInt = i + f.a.a.a.lm(6, this.DNL.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.state) + f.a.a.b.b.a.bx(8, this.EjS) + f.a.a.b.b.a.bx(9, this.EjT);
      paramInt = i;
      if (this.DWw != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DWw);
      }
      AppMethodBeat.o(91395);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EjR.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91395);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        rp localrp = (rp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91395);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bld();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bld)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localrp.EjQ = ((bld)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localrp.DNJ = ((dhb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localrp.EjR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 4: 
          localrp.vwo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91395);
          return 0;
        case 5: 
          localrp.cZz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91395);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localrp.DNL = ((crj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 7: 
          localrp.state = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91395);
          return 0;
        case 8: 
          localrp.EjS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91395);
          return 0;
        case 9: 
          localrp.EjT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91395);
          return 0;
        }
        localrp.DWw = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91395);
        return 0;
      }
      AppMethodBeat.o(91395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rp
 * JD-Core Version:    0.7.0.1
 */