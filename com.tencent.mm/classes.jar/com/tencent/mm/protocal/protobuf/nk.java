package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nk
  extends ckq
{
  public int count;
  public int fVA;
  public String fVB;
  public String fVv;
  public String fVw;
  public String fVx;
  public String fVy;
  public String fVz;
  public int type;
  public int ukO;
  public String vNZ;
  public String vOa;
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124452);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fVv != null) {
        paramVarArgs.d(2, this.fVv);
      }
      if (this.fVw != null) {
        paramVarArgs.d(3, this.fVw);
      }
      if (this.fVx != null) {
        paramVarArgs.d(4, this.fVx);
      }
      if (this.fVy != null) {
        paramVarArgs.d(5, this.fVy);
      }
      if (this.fVz != null) {
        paramVarArgs.d(6, this.fVz);
      }
      paramVarArgs.aR(7, this.fVA);
      if (this.fVB != null) {
        paramVarArgs.d(8, this.fVB);
      }
      if (this.vOa != null) {
        paramVarArgs.d(9, this.vOa);
      }
      if (this.vNZ != null) {
        paramVarArgs.d(10, this.vNZ);
      }
      paramVarArgs.aR(11, this.type);
      if (this.value != null) {
        paramVarArgs.d(12, this.value);
      }
      paramVarArgs.aR(13, this.count);
      paramVarArgs.aR(14, this.ukO);
      AppMethodBeat.o(124452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1046;
      }
    }
    label1046:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fVv != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.fVv);
      }
      i = paramInt;
      if (this.fVw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.fVw);
      }
      paramInt = i;
      if (this.fVx != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.fVx);
      }
      i = paramInt;
      if (this.fVy != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.fVy);
      }
      paramInt = i;
      if (this.fVz != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.fVz);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.fVA);
      paramInt = i;
      if (this.fVB != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.fVB);
      }
      i = paramInt;
      if (this.vOa != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.vOa);
      }
      paramInt = i;
      if (this.vNZ != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.vNZ);
      }
      i = paramInt + f.a.a.b.b.a.bA(11, this.type);
      paramInt = i;
      if (this.value != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.value);
      }
      i = f.a.a.b.b.a.bA(13, this.count);
      int j = f.a.a.b.b.a.bA(14, this.ukO);
      AppMethodBeat.o(124452);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124452);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        nk localnk = (nk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124452);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnk.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124452);
          return 0;
        case 2: 
          localnk.fVv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 3: 
          localnk.fVw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 4: 
          localnk.fVx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 5: 
          localnk.fVy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 6: 
          localnk.fVz = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 7: 
          localnk.fVA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124452);
          return 0;
        case 8: 
          localnk.fVB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 9: 
          localnk.vOa = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 10: 
          localnk.vNZ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 11: 
          localnk.type = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124452);
          return 0;
        case 12: 
          localnk.value = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 13: 
          localnk.count = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124452);
          return 0;
        }
        localnk.ukO = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(124452);
        return 0;
      }
      AppMethodBeat.o(124452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nk
 * JD-Core Version:    0.7.0.1
 */