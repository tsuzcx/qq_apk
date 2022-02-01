package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rf
  extends com.tencent.mm.bx.a
{
  public String CDW;
  public bhl CRf;
  public LinkedList<dbp> CRg;
  public int CRh;
  public int CRi;
  public dbp Cvo;
  public cmc Cvq;
  public String dca;
  public int state;
  public String uns;
  
  public rf()
  {
    AppMethodBeat.i(91394);
    this.CRg = new LinkedList();
    AppMethodBeat.o(91394);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91395);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CRf != null)
      {
        paramVarArgs.kX(1, this.CRf.computeSize());
        this.CRf.writeFields(paramVarArgs);
      }
      if (this.Cvo != null)
      {
        paramVarArgs.kX(2, this.Cvo.computeSize());
        this.Cvo.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.CRg);
      if (this.uns != null) {
        paramVarArgs.d(4, this.uns);
      }
      if (this.dca != null) {
        paramVarArgs.d(5, this.dca);
      }
      if (this.Cvq != null)
      {
        paramVarArgs.kX(6, this.Cvq.computeSize());
        this.Cvq.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.state);
      paramVarArgs.aR(8, this.CRh);
      paramVarArgs.aR(9, this.CRi);
      if (this.CDW != null) {
        paramVarArgs.d(10, this.CDW);
      }
      AppMethodBeat.o(91395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CRf == null) {
        break label1078;
      }
    }
    label1078:
    for (paramInt = f.a.a.a.kW(1, this.CRf.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Cvo != null) {
        i = paramInt + f.a.a.a.kW(2, this.Cvo.computeSize());
      }
      i += f.a.a.a.c(3, 8, this.CRg);
      paramInt = i;
      if (this.uns != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uns);
      }
      i = paramInt;
      if (this.dca != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dca);
      }
      paramInt = i;
      if (this.Cvq != null) {
        paramInt = i + f.a.a.a.kW(6, this.Cvq.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.state) + f.a.a.b.b.a.bA(8, this.CRh) + f.a.a.b.b.a.bA(9, this.CRi);
      paramInt = i;
      if (this.CDW != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.CDW);
      }
      AppMethodBeat.o(91395);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CRg.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91395);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        rf localrf = (rf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91395);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bhl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bhl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localrf.CRf = ((bhl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localrf.Cvo = ((dbp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localrf.CRg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 4: 
          localrf.uns = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91395);
          return 0;
        case 5: 
          localrf.dca = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91395);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localrf.Cvq = ((cmc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 7: 
          localrf.state = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91395);
          return 0;
        case 8: 
          localrf.CRh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91395);
          return 0;
        case 9: 
          localrf.CRi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91395);
          return 0;
        }
        localrf.CDW = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91395);
        return 0;
      }
      AppMethodBeat.o(91395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rf
 * JD-Core Version:    0.7.0.1
 */