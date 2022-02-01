package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class sz
  extends ckq
{
  public String CUD;
  public String CUJ;
  public String CUK;
  public int CUL;
  public String CUM;
  public String CUN;
  public String CUO;
  public String CUP;
  public int CUQ;
  public int channel;
  public int tav;
  public String vBj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72437);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CUJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_name");
        AppMethodBeat.o(72437);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CUJ != null) {
        paramVarArgs.d(2, this.CUJ);
      }
      paramVarArgs.aR(3, this.tav);
      if (this.CUK != null) {
        paramVarArgs.d(4, this.CUK);
      }
      if (this.vBj != null) {
        paramVarArgs.d(5, this.vBj);
      }
      paramVarArgs.aR(6, this.CUL);
      paramVarArgs.aR(7, this.channel);
      if (this.CUM != null) {
        paramVarArgs.d(8, this.CUM);
      }
      if (this.CUD != null) {
        paramVarArgs.d(9, this.CUD);
      }
      if (this.CUN != null) {
        paramVarArgs.d(10, this.CUN);
      }
      if (this.CUO != null) {
        paramVarArgs.d(11, this.CUO);
      }
      if (this.CUP != null) {
        paramVarArgs.d(12, this.CUP);
      }
      paramVarArgs.aR(13, this.CUQ);
      AppMethodBeat.o(72437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1030;
      }
    }
    label1030:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CUJ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.CUJ);
      }
      i += f.a.a.b.b.a.bA(3, this.tav);
      paramInt = i;
      if (this.CUK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CUK);
      }
      i = paramInt;
      if (this.vBj != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.vBj);
      }
      i = i + f.a.a.b.b.a.bA(6, this.CUL) + f.a.a.b.b.a.bA(7, this.channel);
      paramInt = i;
      if (this.CUM != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CUM);
      }
      i = paramInt;
      if (this.CUD != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.CUD);
      }
      paramInt = i;
      if (this.CUN != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.CUN);
      }
      i = paramInt;
      if (this.CUO != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.CUO);
      }
      paramInt = i;
      if (this.CUP != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.CUP);
      }
      i = f.a.a.b.b.a.bA(13, this.CUQ);
      AppMethodBeat.o(72437);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CUJ == null)
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
        sz localsz = (sz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72437);
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
            localsz.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72437);
          return 0;
        case 2: 
          localsz.CUJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 3: 
          localsz.tav = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72437);
          return 0;
        case 4: 
          localsz.CUK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 5: 
          localsz.vBj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 6: 
          localsz.CUL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72437);
          return 0;
        case 7: 
          localsz.channel = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72437);
          return 0;
        case 8: 
          localsz.CUM = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 9: 
          localsz.CUD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 10: 
          localsz.CUN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 11: 
          localsz.CUO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 12: 
          localsz.CUP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72437);
          return 0;
        }
        localsz.CUQ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(72437);
        return 0;
      }
      AppMethodBeat.o(72437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sz
 * JD-Core Version:    0.7.0.1
 */