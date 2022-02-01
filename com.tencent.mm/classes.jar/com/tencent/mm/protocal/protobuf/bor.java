package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bor
  extends com.tencent.mm.bw.a
{
  public String GKU;
  public int GKV;
  public String GKW;
  public boolean GKX = false;
  public boolean GKY = false;
  public dol Hca;
  public dol Hcb;
  public String Hcc;
  public String Hcd;
  public boolean Hce = false;
  public boolean Hcf;
  public bov Hcg;
  public dwx Hch;
  public bcx Hci;
  public int flags;
  public int msgType = -1;
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122507);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.msgType);
      if (this.Hca != null)
      {
        paramVarArgs.lJ(2, this.Hca.computeSize());
        this.Hca.writeFields(paramVarArgs);
      }
      if (this.Hcb != null)
      {
        paramVarArgs.lJ(3, this.Hcb.computeSize());
        this.Hcb.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(4, this.GKX);
      if (this.GKU != null) {
        paramVarArgs.d(5, this.GKU);
      }
      paramVarArgs.aS(6, this.flags);
      if (this.GKW != null) {
        paramVarArgs.d(7, this.GKW);
      }
      if (this.Hcc != null) {
        paramVarArgs.d(8, this.Hcc);
      }
      if (this.Hcd != null) {
        paramVarArgs.d(9, this.Hcd);
      }
      paramVarArgs.bC(10, this.Hce);
      paramVarArgs.bC(11, this.Hcf);
      paramVarArgs.bC(12, this.GKY);
      if (this.Hcg != null)
      {
        paramVarArgs.lJ(13, this.Hcg.computeSize());
        this.Hcg.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(14, this.timestamp);
      if (this.Hch != null)
      {
        paramVarArgs.lJ(15, this.Hch.computeSize());
        this.Hch.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(16, this.GKV);
      if (this.Hci != null)
      {
        paramVarArgs.lJ(17, this.Hci.computeSize());
        this.Hci.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(122507);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.msgType) + 0;
      paramInt = i;
      if (this.Hca != null) {
        paramInt = i + f.a.a.a.lI(2, this.Hca.computeSize());
      }
      i = paramInt;
      if (this.Hcb != null) {
        i = paramInt + f.a.a.a.lI(3, this.Hcb.computeSize());
      }
      i += f.a.a.b.b.a.amF(4);
      paramInt = i;
      if (this.GKU != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GKU);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.flags);
      paramInt = i;
      if (this.GKW != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GKW);
      }
      i = paramInt;
      if (this.Hcc != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Hcc);
      }
      paramInt = i;
      if (this.Hcd != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Hcd);
      }
      i = paramInt + f.a.a.b.b.a.amF(10) + f.a.a.b.b.a.amF(11) + f.a.a.b.b.a.amF(12);
      paramInt = i;
      if (this.Hcg != null) {
        paramInt = i + f.a.a.a.lI(13, this.Hcg.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.p(14, this.timestamp);
      paramInt = i;
      if (this.Hch != null) {
        paramInt = i + f.a.a.a.lI(15, this.Hch.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(16, this.GKV);
      paramInt = i;
      if (this.Hci != null) {
        paramInt = i + f.a.a.a.lI(17, this.Hci.computeSize());
      }
      AppMethodBeat.o(122507);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(122507);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bor localbor = (bor)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122507);
        return -1;
      case 1: 
        localbor.msgType = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(122507);
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
          localbor.Hca = ((dol)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dol();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dol)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbor.Hcb = ((dol)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      case 4: 
        localbor.GKX = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(122507);
        return 0;
      case 5: 
        localbor.GKU = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 6: 
        localbor.flags = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(122507);
        return 0;
      case 7: 
        localbor.GKW = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 8: 
        localbor.Hcc = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 9: 
        localbor.Hcd = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 10: 
        localbor.Hce = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(122507);
        return 0;
      case 11: 
        localbor.Hcf = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(122507);
        return 0;
      case 12: 
        localbor.GKY = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(122507);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bov();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bov)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbor.Hcg = ((bov)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      case 14: 
        localbor.timestamp = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(122507);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dwx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dwx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbor.Hch = ((dwx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      case 16: 
        localbor.GKV = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(122507);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bcx();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bcx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbor.Hci = ((bcx)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(122507);
      return 0;
    }
    AppMethodBeat.o(122507);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bor
 * JD-Core Version:    0.7.0.1
 */