package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class czw
  extends ckq
{
  public b Buffer;
  public int CID;
  public String CIt;
  public int CKO;
  public int ErD;
  public String ErE;
  public cbc ErF;
  public int Ery;
  public int Scene;
  public String hnC;
  public LinkedList<czv> saZ;
  
  public czw()
  {
    AppMethodBeat.i(152704);
    this.saZ = new LinkedList();
    AppMethodBeat.o(152704);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152705);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CIt != null) {
        paramVarArgs.d(2, this.CIt);
      }
      paramVarArgs.aR(3, this.CKO);
      paramVarArgs.e(4, 8, this.saZ);
      paramVarArgs.aR(5, this.ErD);
      if (this.hnC != null) {
        paramVarArgs.d(6, this.hnC);
      }
      paramVarArgs.aR(7, this.CID);
      paramVarArgs.aR(8, this.Ery);
      if (this.ErE != null) {
        paramVarArgs.d(9, this.ErE);
      }
      if (this.Buffer != null) {
        paramVarArgs.c(10, this.Buffer);
      }
      if (this.ErF != null)
      {
        paramVarArgs.kX(11, this.ErF.computeSize());
        this.ErF.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(12, this.Scene);
      AppMethodBeat.o(152705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1074;
      }
    }
    label1074:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CIt != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.CIt);
      }
      i = i + f.a.a.b.b.a.bA(3, this.CKO) + f.a.a.a.c(4, 8, this.saZ) + f.a.a.b.b.a.bA(5, this.ErD);
      paramInt = i;
      if (this.hnC != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.hnC);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.CID) + f.a.a.b.b.a.bA(8, this.Ery);
      paramInt = i;
      if (this.ErE != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.ErE);
      }
      i = paramInt;
      if (this.Buffer != null) {
        i = paramInt + f.a.a.b.b.a.b(10, this.Buffer);
      }
      paramInt = i;
      if (this.ErF != null) {
        paramInt = i + f.a.a.a.kW(11, this.ErF.computeSize());
      }
      i = f.a.a.b.b.a.bA(12, this.Scene);
      AppMethodBeat.o(152705);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.saZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152705);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czw localczw = (czw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152705);
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
            localczw.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152705);
          return 0;
        case 2: 
          localczw.CIt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152705);
          return 0;
        case 3: 
          localczw.CKO = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152705);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new czv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((czv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczw.saZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152705);
          return 0;
        case 5: 
          localczw.ErD = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152705);
          return 0;
        case 6: 
          localczw.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152705);
          return 0;
        case 7: 
          localczw.CID = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152705);
          return 0;
        case 8: 
          localczw.Ery = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152705);
          return 0;
        case 9: 
          localczw.ErE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152705);
          return 0;
        case 10: 
          localczw.Buffer = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(152705);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczw.ErF = ((cbc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152705);
          return 0;
        }
        localczw.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152705);
        return 0;
      }
      AppMethodBeat.o(152705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czw
 * JD-Core Version:    0.7.0.1
 */