package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdp
  extends ckq
{
  public int CLL;
  public int DAL;
  public boolean DAM;
  public bxq DAN;
  public String DAO;
  public LinkedList<brz> DAP;
  public int DAQ;
  public boolean DAR;
  public boolean DAS;
  public String DyR;
  public int DyU;
  public String dlB;
  public String kKY;
  public String path;
  public int scene;
  public int type;
  public String username;
  
  public bdp()
  {
    AppMethodBeat.i(123586);
    this.DAM = false;
    this.DAP = new LinkedList();
    AppMethodBeat.o(123586);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123587);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.type);
      if (this.dlB != null) {
        paramVarArgs.d(3, this.dlB);
      }
      paramVarArgs.aR(4, this.CLL);
      if (this.kKY != null) {
        paramVarArgs.d(5, this.kKY);
      }
      paramVarArgs.aR(6, this.DyU);
      paramVarArgs.aR(7, this.DAL);
      if (this.DyR != null) {
        paramVarArgs.d(8, this.DyR);
      }
      paramVarArgs.bg(9, this.DAM);
      if (this.DAN != null)
      {
        paramVarArgs.kX(10, this.DAN.computeSize());
        this.DAN.writeFields(paramVarArgs);
      }
      if (this.DAO != null) {
        paramVarArgs.d(11, this.DAO);
      }
      paramVarArgs.e(12, 8, this.DAP);
      paramVarArgs.aR(13, this.DAQ);
      if (this.username != null) {
        paramVarArgs.d(14, this.username);
      }
      if (this.path != null) {
        paramVarArgs.d(15, this.path);
      }
      paramVarArgs.bg(16, this.DAR);
      paramVarArgs.bg(17, this.DAS);
      paramVarArgs.aR(18, this.scene);
      AppMethodBeat.o(123587);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1382;
      }
    }
    label1382:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.type);
      paramInt = i;
      if (this.dlB != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dlB);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.CLL);
      paramInt = i;
      if (this.kKY != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.kKY);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.DyU) + f.a.a.b.b.a.bA(7, this.DAL);
      paramInt = i;
      if (this.DyR != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DyR);
      }
      i = paramInt + (f.a.a.b.b.a.fY(9) + 1);
      paramInt = i;
      if (this.DAN != null) {
        paramInt = i + f.a.a.a.kW(10, this.DAN.computeSize());
      }
      i = paramInt;
      if (this.DAO != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.DAO);
      }
      i = i + f.a.a.a.c(12, 8, this.DAP) + f.a.a.b.b.a.bA(13, this.DAQ);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.username);
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.path);
      }
      paramInt = f.a.a.b.b.a.fY(16);
      int j = f.a.a.b.b.a.fY(17);
      int k = f.a.a.b.b.a.bA(18, this.scene);
      AppMethodBeat.o(123587);
      return i + (paramInt + 1) + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DAP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123587);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bdp localbdp = (bdp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123587);
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
            localbdp.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123587);
          return 0;
        case 2: 
          localbdp.type = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123587);
          return 0;
        case 3: 
          localbdp.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 4: 
          localbdp.CLL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123587);
          return 0;
        case 5: 
          localbdp.kKY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 6: 
          localbdp.DyU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123587);
          return 0;
        case 7: 
          localbdp.DAL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123587);
          return 0;
        case 8: 
          localbdp.DyR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 9: 
          localbdp.DAM = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(123587);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdp.DAN = ((bxq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123587);
          return 0;
        case 11: 
          localbdp.DAO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new brz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((brz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdp.DAP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123587);
          return 0;
        case 13: 
          localbdp.DAQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123587);
          return 0;
        case 14: 
          localbdp.username = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 15: 
          localbdp.path = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 16: 
          localbdp.DAR = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(123587);
          return 0;
        case 17: 
          localbdp.DAS = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(123587);
          return 0;
        }
        localbdp.scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(123587);
        return 0;
      }
      AppMethodBeat.o(123587);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdp
 * JD-Core Version:    0.7.0.1
 */