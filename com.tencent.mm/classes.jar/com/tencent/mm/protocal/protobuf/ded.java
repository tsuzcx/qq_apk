package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ded
  extends cld
{
  public String CHl;
  public civ EvG;
  public LinkedList<aav> EvH;
  public String EvI;
  public String EvJ;
  public String EvK;
  public civ Evv;
  public String Evw;
  public String Evx;
  public String Evy;
  public String nrG;
  public int ntx;
  public String nty;
  public int vBt;
  public String vxp;
  public String vxq;
  public int vxr;
  
  public ded()
  {
    AppMethodBeat.i(72598);
    this.EvH = new LinkedList();
    AppMethodBeat.o(72598);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72599);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ntx);
      if (this.nty != null) {
        paramVarArgs.d(3, this.nty);
      }
      paramVarArgs.aR(4, this.vxr);
      if (this.EvG != null)
      {
        paramVarArgs.kX(5, this.EvG.computeSize());
        this.EvG.writeFields(paramVarArgs);
      }
      if (this.Evw != null) {
        paramVarArgs.d(6, this.Evw);
      }
      if (this.Evx != null) {
        paramVarArgs.d(7, this.Evx);
      }
      if (this.vxp != null) {
        paramVarArgs.d(8, this.vxp);
      }
      if (this.vxq != null) {
        paramVarArgs.d(9, this.vxq);
      }
      if (this.nrG != null) {
        paramVarArgs.d(10, this.nrG);
      }
      if (this.CHl != null) {
        paramVarArgs.d(11, this.CHl);
      }
      paramVarArgs.aR(12, this.vBt);
      paramVarArgs.e(13, 8, this.EvH);
      if (this.EvI != null) {
        paramVarArgs.d(14, this.EvI);
      }
      if (this.EvJ != null) {
        paramVarArgs.d(15, this.EvJ);
      }
      if (this.Evy != null) {
        paramVarArgs.d(16, this.Evy);
      }
      if (this.EvK != null) {
        paramVarArgs.d(17, this.EvK);
      }
      if (this.Evv != null)
      {
        paramVarArgs.kX(18, this.Evv.computeSize());
        this.Evv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72599);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1574;
      }
    }
    label1574:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.vxr);
      paramInt = i;
      if (this.EvG != null) {
        paramInt = i + f.a.a.a.kW(5, this.EvG.computeSize());
      }
      i = paramInt;
      if (this.Evw != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Evw);
      }
      paramInt = i;
      if (this.Evx != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Evx);
      }
      i = paramInt;
      if (this.vxp != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.vxp);
      }
      paramInt = i;
      if (this.vxq != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.vxq);
      }
      i = paramInt;
      if (this.nrG != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.nrG);
      }
      paramInt = i;
      if (this.CHl != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.CHl);
      }
      i = paramInt + f.a.a.b.b.a.bA(12, this.vBt) + f.a.a.a.c(13, 8, this.EvH);
      paramInt = i;
      if (this.EvI != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.EvI);
      }
      i = paramInt;
      if (this.EvJ != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.EvJ);
      }
      paramInt = i;
      if (this.Evy != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.Evy);
      }
      i = paramInt;
      if (this.EvK != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.EvK);
      }
      paramInt = i;
      if (this.Evv != null) {
        paramInt = i + f.a.a.a.kW(18, this.Evv.computeSize());
      }
      AppMethodBeat.o(72599);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EvH.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72599);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ded localded = (ded)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72599);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localded.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72599);
          return 0;
        case 2: 
          localded.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72599);
          return 0;
        case 3: 
          localded.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 4: 
          localded.vxr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72599);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new civ();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((civ)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localded.EvG = ((civ)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72599);
          return 0;
        case 6: 
          localded.Evw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 7: 
          localded.Evx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 8: 
          localded.vxp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 9: 
          localded.vxq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 10: 
          localded.nrG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 11: 
          localded.CHl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 12: 
          localded.vBt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72599);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aav();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aav)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localded.EvH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72599);
          return 0;
        case 14: 
          localded.EvI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 15: 
          localded.EvJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 16: 
          localded.Evy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72599);
          return 0;
        case 17: 
          localded.EvK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72599);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new civ();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((civ)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localded.Evv = ((civ)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72599);
        return 0;
      }
      AppMethodBeat.o(72599);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ded
 * JD-Core Version:    0.7.0.1
 */