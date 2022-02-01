package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class uj
  extends ckq
{
  public int CWa;
  public LinkedList<cmf> CWb;
  public String CWc;
  public String CWd;
  public int Scene;
  public String fVC;
  public int rNz;
  public String sdP;
  public String sed;
  
  public uj()
  {
    AppMethodBeat.i(124468);
    this.CWb = new LinkedList();
    AppMethodBeat.o(124468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124469);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.rNz);
      if (this.sdP != null) {
        paramVarArgs.d(3, this.sdP);
      }
      if (this.sed != null) {
        paramVarArgs.d(4, this.sed);
      }
      if (this.fVC != null) {
        paramVarArgs.d(5, this.fVC);
      }
      paramVarArgs.aR(6, this.CWa);
      paramVarArgs.e(7, 8, this.CWb);
      if (this.CWc != null) {
        paramVarArgs.d(8, this.CWc);
      }
      if (this.CWd != null) {
        paramVarArgs.d(9, this.CWd);
      }
      paramVarArgs.aR(10, this.Scene);
      AppMethodBeat.o(124469);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label890;
      }
    }
    label890:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.rNz);
      paramInt = i;
      if (this.sdP != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.sdP);
      }
      i = paramInt;
      if (this.sed != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.sed);
      }
      paramInt = i;
      if (this.fVC != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.fVC);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.CWa) + f.a.a.a.c(7, 8, this.CWb);
      paramInt = i;
      if (this.CWc != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CWc);
      }
      i = paramInt;
      if (this.CWd != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.CWd);
      }
      paramInt = f.a.a.b.b.a.bA(10, this.Scene);
      AppMethodBeat.o(124469);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CWb.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124469);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        uj localuj = (uj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124469);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localuj.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124469);
          return 0;
        case 2: 
          localuj.rNz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124469);
          return 0;
        case 3: 
          localuj.sdP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 4: 
          localuj.sed = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 5: 
          localuj.fVC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 6: 
          localuj.CWa = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124469);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localuj.CWb.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124469);
          return 0;
        case 8: 
          localuj.CWc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 9: 
          localuj.CWd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124469);
          return 0;
        }
        localuj.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(124469);
        return 0;
      }
      AppMethodBeat.o(124469);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uj
 * JD-Core Version:    0.7.0.1
 */