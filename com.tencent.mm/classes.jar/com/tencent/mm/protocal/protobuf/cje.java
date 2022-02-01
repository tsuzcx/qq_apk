package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cje
  extends cvw
{
  public String GMp;
  public bb Ghz;
  public String GpD;
  public String GpE;
  public String GpF;
  public String GpG;
  public String HvN;
  public String HvO;
  public String HvP;
  public String HvQ;
  public String HvR;
  public String ikm;
  public String uqs;
  public String uuo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91571);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ikm != null) {
        paramVarArgs.d(2, this.ikm);
      }
      if (this.HvN != null) {
        paramVarArgs.d(3, this.HvN);
      }
      if (this.GMp != null) {
        paramVarArgs.d(4, this.GMp);
      }
      if (this.GpD != null) {
        paramVarArgs.d(5, this.GpD);
      }
      if (this.HvO != null) {
        paramVarArgs.d(6, this.HvO);
      }
      if (this.GpE != null) {
        paramVarArgs.d(7, this.GpE);
      }
      if (this.GpF != null) {
        paramVarArgs.d(8, this.GpF);
      }
      if (this.GpG != null) {
        paramVarArgs.d(9, this.GpG);
      }
      if (this.HvP != null) {
        paramVarArgs.d(10, this.HvP);
      }
      if (this.Ghz != null)
      {
        paramVarArgs.lJ(11, this.Ghz.computeSize());
        this.Ghz.writeFields(paramVarArgs);
      }
      if (this.HvQ != null) {
        paramVarArgs.d(12, this.HvQ);
      }
      if (this.uqs != null) {
        paramVarArgs.d(13, this.uqs);
      }
      if (this.uuo != null) {
        paramVarArgs.d(14, this.uuo);
      }
      if (this.HvR != null) {
        paramVarArgs.d(15, this.HvR);
      }
      AppMethodBeat.o(91571);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1266;
      }
    }
    label1266:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ikm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ikm);
      }
      i = paramInt;
      if (this.HvN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HvN);
      }
      paramInt = i;
      if (this.GMp != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GMp);
      }
      i = paramInt;
      if (this.GpD != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GpD);
      }
      paramInt = i;
      if (this.HvO != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HvO);
      }
      i = paramInt;
      if (this.GpE != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GpE);
      }
      paramInt = i;
      if (this.GpF != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GpF);
      }
      i = paramInt;
      if (this.GpG != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GpG);
      }
      paramInt = i;
      if (this.HvP != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.HvP);
      }
      i = paramInt;
      if (this.Ghz != null) {
        i = paramInt + f.a.a.a.lI(11, this.Ghz.computeSize());
      }
      paramInt = i;
      if (this.HvQ != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.HvQ);
      }
      i = paramInt;
      if (this.uqs != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.uqs);
      }
      paramInt = i;
      if (this.uuo != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.uuo);
      }
      i = paramInt;
      if (this.HvR != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.HvR);
      }
      AppMethodBeat.o(91571);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91571);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cje localcje = (cje)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91571);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcje.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91571);
          return 0;
        case 2: 
          localcje.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 3: 
          localcje.HvN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 4: 
          localcje.GMp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 5: 
          localcje.GpD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 6: 
          localcje.HvO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 7: 
          localcje.GpE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 8: 
          localcje.GpF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 9: 
          localcje.GpG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 10: 
          localcje.HvP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcje.Ghz = ((bb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91571);
          return 0;
        case 12: 
          localcje.HvQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 13: 
          localcje.uqs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91571);
          return 0;
        case 14: 
          localcje.uuo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91571);
          return 0;
        }
        localcje.HvR = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91571);
        return 0;
      }
      AppMethodBeat.o(91571);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cje
 * JD-Core Version:    0.7.0.1
 */