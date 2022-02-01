package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dix
  extends com.tencent.mm.bw.a
{
  public String GKU;
  public String GKW;
  public boolean GKX = false;
  public dol Hca;
  public dol Hcb;
  public String Hcc;
  public String Hcd;
  public int flags;
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122550);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hca != null)
      {
        paramVarArgs.lJ(1, this.Hca.computeSize());
        this.Hca.writeFields(paramVarArgs);
      }
      if (this.Hcb != null)
      {
        paramVarArgs.lJ(2, this.Hcb.computeSize());
        this.Hcb.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(3, this.GKX);
      if (this.GKU != null) {
        paramVarArgs.d(4, this.GKU);
      }
      paramVarArgs.aS(5, this.flags);
      if (this.GKW != null) {
        paramVarArgs.d(6, this.GKW);
      }
      if (this.Hcc != null) {
        paramVarArgs.d(7, this.Hcc);
      }
      if (this.Hcd != null) {
        paramVarArgs.d(8, this.Hcd);
      }
      paramVarArgs.aZ(9, this.timestamp);
      AppMethodBeat.o(122550);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hca == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = f.a.a.a.lI(1, this.Hca.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hcb != null) {
        i = paramInt + f.a.a.a.lI(2, this.Hcb.computeSize());
      }
      i += f.a.a.b.b.a.amF(3);
      paramInt = i;
      if (this.GKU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GKU);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.flags);
      paramInt = i;
      if (this.GKW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GKW);
      }
      i = paramInt;
      if (this.Hcc != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Hcc);
      }
      paramInt = i;
      if (this.Hcd != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Hcd);
      }
      i = f.a.a.b.b.a.p(9, this.timestamp);
      AppMethodBeat.o(122550);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(122550);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dix localdix = (dix)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122550);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dol();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dol)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdix.Hca = ((dol)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122550);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dol();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dol)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdix.Hcb = ((dol)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122550);
          return 0;
        case 3: 
          localdix.GKX = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(122550);
          return 0;
        case 4: 
          localdix.GKU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122550);
          return 0;
        case 5: 
          localdix.flags = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(122550);
          return 0;
        case 6: 
          localdix.GKW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122550);
          return 0;
        case 7: 
          localdix.Hcc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122550);
          return 0;
        case 8: 
          localdix.Hcd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122550);
          return 0;
        }
        localdix.timestamp = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(122550);
        return 0;
      }
      AppMethodBeat.o(122550);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dix
 * JD-Core Version:    0.7.0.1
 */