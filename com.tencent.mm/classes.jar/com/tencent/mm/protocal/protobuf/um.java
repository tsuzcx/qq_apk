package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class um
  extends cvp
{
  public String CTa;
  public int FTC;
  public LinkedList<byw> FTJ;
  public byw FTK;
  public String FTL;
  public boolean FTM;
  public String FTN;
  public int FTO;
  public bzd FTP;
  public cra FTQ;
  public String FTR;
  public String FTS;
  public String FTT;
  public cnv FTU;
  public cnv FTV;
  public cnv FTW;
  public com.tencent.mm.bx.b FTX;
  public int dlw;
  public String iTH;
  public String iTI;
  public String url;
  public int xYX;
  public String xYY;
  public String xYZ;
  
  public um()
  {
    AppMethodBeat.i(91406);
    this.FTJ = new LinkedList();
    AppMethodBeat.o(91406);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91407);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91407);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      paramVarArgs.e(3, 8, this.FTJ);
      if (this.FTK != null)
      {
        paramVarArgs.lC(4, this.FTK.computeSize());
        this.FTK.writeFields(paramVarArgs);
      }
      if (this.CTa != null) {
        paramVarArgs.d(5, this.CTa);
      }
      if (this.FTL != null) {
        paramVarArgs.d(6, this.FTL);
      }
      paramVarArgs.bt(7, this.FTM);
      paramVarArgs.aS(8, this.xYX);
      if (this.FTN != null) {
        paramVarArgs.d(9, this.FTN);
      }
      if (this.xYY != null) {
        paramVarArgs.d(10, this.xYY);
      }
      if (this.xYZ != null) {
        paramVarArgs.d(11, this.xYZ);
      }
      paramVarArgs.aS(12, this.FTO);
      if (this.FTP != null)
      {
        paramVarArgs.lC(13, this.FTP.computeSize());
        this.FTP.writeFields(paramVarArgs);
      }
      if (this.FTQ != null)
      {
        paramVarArgs.lC(14, this.FTQ.computeSize());
        this.FTQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(15, this.dlw);
      paramVarArgs.aS(16, this.FTC);
      if (this.iTH != null) {
        paramVarArgs.d(17, this.iTH);
      }
      if (this.iTI != null) {
        paramVarArgs.d(18, this.iTI);
      }
      if (this.FTR != null) {
        paramVarArgs.d(19, this.FTR);
      }
      if (this.FTS != null) {
        paramVarArgs.d(20, this.FTS);
      }
      if (this.FTT != null) {
        paramVarArgs.d(21, this.FTT);
      }
      if (this.FTU != null)
      {
        paramVarArgs.lC(22, this.FTU.computeSize());
        this.FTU.writeFields(paramVarArgs);
      }
      if (this.FTV != null)
      {
        paramVarArgs.lC(23, this.FTV.computeSize());
        this.FTV.writeFields(paramVarArgs);
      }
      if (this.FTW != null)
      {
        paramVarArgs.lC(24, this.FTW.computeSize());
        this.FTW.writeFields(paramVarArgs);
      }
      if (this.FTX != null) {
        paramVarArgs.c(25, this.FTX);
      }
      AppMethodBeat.o(91407);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2394;
      }
    }
    label2394:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.url);
      }
      i += f.a.a.a.c(3, 8, this.FTJ);
      paramInt = i;
      if (this.FTK != null) {
        paramInt = i + f.a.a.a.lB(4, this.FTK.computeSize());
      }
      i = paramInt;
      if (this.CTa != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CTa);
      }
      paramInt = i;
      if (this.FTL != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FTL);
      }
      i = paramInt + f.a.a.b.b.a.alV(7) + f.a.a.b.b.a.bz(8, this.xYX);
      paramInt = i;
      if (this.FTN != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FTN);
      }
      i = paramInt;
      if (this.xYY != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.xYY);
      }
      paramInt = i;
      if (this.xYZ != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.xYZ);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.FTO);
      paramInt = i;
      if (this.FTP != null) {
        paramInt = i + f.a.a.a.lB(13, this.FTP.computeSize());
      }
      i = paramInt;
      if (this.FTQ != null) {
        i = paramInt + f.a.a.a.lB(14, this.FTQ.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(15, this.dlw) + f.a.a.b.b.a.bz(16, this.FTC);
      paramInt = i;
      if (this.iTH != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.iTH);
      }
      i = paramInt;
      if (this.iTI != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.iTI);
      }
      paramInt = i;
      if (this.FTR != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.FTR);
      }
      i = paramInt;
      if (this.FTS != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.FTS);
      }
      paramInt = i;
      if (this.FTT != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.FTT);
      }
      i = paramInt;
      if (this.FTU != null) {
        i = paramInt + f.a.a.a.lB(22, this.FTU.computeSize());
      }
      paramInt = i;
      if (this.FTV != null) {
        paramInt = i + f.a.a.a.lB(23, this.FTV.computeSize());
      }
      i = paramInt;
      if (this.FTW != null) {
        i = paramInt + f.a.a.a.lB(24, this.FTW.computeSize());
      }
      paramInt = i;
      if (this.FTX != null) {
        paramInt = i + f.a.a.b.b.a.b(25, this.FTX);
      }
      AppMethodBeat.o(91407);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FTJ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91407);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91407);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        um localum = (um)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91407);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localum.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 2: 
          localum.url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new byw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((byw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localum.FTJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new byw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((byw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localum.FTK = ((byw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 5: 
          localum.CTa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 6: 
          localum.FTL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 7: 
          localum.FTM = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91407);
          return 0;
        case 8: 
          localum.xYX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91407);
          return 0;
        case 9: 
          localum.FTN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 10: 
          localum.xYY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 11: 
          localum.xYZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 12: 
          localum.FTO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91407);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localum.FTP = ((bzd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cra();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cra)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localum.FTQ = ((cra)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 15: 
          localum.dlw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91407);
          return 0;
        case 16: 
          localum.FTC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91407);
          return 0;
        case 17: 
          localum.iTH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 18: 
          localum.iTI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 19: 
          localum.FTR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 20: 
          localum.FTS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 21: 
          localum.FTT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localum.FTU = ((cnv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localum.FTV = ((cnv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 24: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localum.FTW = ((cnv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        }
        localum.FTX = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(91407);
        return 0;
      }
      AppMethodBeat.o(91407);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.um
 * JD-Core Version:    0.7.0.1
 */