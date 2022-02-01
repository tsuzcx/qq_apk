package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcn
  extends com.tencent.mm.bx.a
{
  public LinkedList<xp> AFX;
  public String AGg;
  public LinkedList<dcx> EtT;
  public int EtU;
  public String EtV;
  public String EtW;
  public LinkedList<String> EtX;
  public amb EtY;
  public int cJR;
  public String dcm;
  public String dnB;
  public String dtw;
  public String jko;
  public int offset;
  public String qGK;
  public String qwV;
  public int scene;
  public String sessionId;
  public int svd;
  public String url;
  public int yMc;
  
  public dcn()
  {
    AppMethodBeat.i(152996);
    this.AFX = new LinkedList();
    this.EtT = new LinkedList();
    this.EtX = new LinkedList();
    AppMethodBeat.o(152996);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152997);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.jko != null) {
        paramVarArgs.d(1, this.jko);
      }
      if (this.sessionId != null) {
        paramVarArgs.d(2, this.sessionId);
      }
      if (this.dtw != null) {
        paramVarArgs.d(3, this.dtw);
      }
      paramVarArgs.aR(4, this.offset);
      if (this.dcm != null) {
        paramVarArgs.d(5, this.dcm);
      }
      paramVarArgs.aR(6, this.scene);
      if (this.url != null) {
        paramVarArgs.d(7, this.url);
      }
      if (this.dnB != null) {
        paramVarArgs.d(8, this.dnB);
      }
      paramVarArgs.e(9, 8, this.AFX);
      if (this.qwV != null) {
        paramVarArgs.d(10, this.qwV);
      }
      paramVarArgs.e(11, 8, this.EtT);
      paramVarArgs.aR(12, this.yMc);
      paramVarArgs.aR(13, this.cJR);
      if (this.AGg != null) {
        paramVarArgs.d(14, this.AGg);
      }
      paramVarArgs.aR(15, this.EtU);
      if (this.EtV != null) {
        paramVarArgs.d(16, this.EtV);
      }
      if (this.qGK != null) {
        paramVarArgs.d(17, this.qGK);
      }
      if (this.EtW != null) {
        paramVarArgs.d(18, this.EtW);
      }
      paramVarArgs.e(19, 1, this.EtX);
      paramVarArgs.aR(20, this.svd);
      if (this.EtY != null)
      {
        paramVarArgs.kX(21, this.EtY.computeSize());
        this.EtY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152997);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jko == null) {
        break label1598;
      }
    }
    label1598:
    for (int i = f.a.a.b.b.a.e(1, this.jko) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sessionId);
      }
      i = paramInt;
      if (this.dtw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dtw);
      }
      i += f.a.a.b.b.a.bA(4, this.offset);
      paramInt = i;
      if (this.dcm != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dcm);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.url);
      }
      i = paramInt;
      if (this.dnB != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.dnB);
      }
      i += f.a.a.a.c(9, 8, this.AFX);
      paramInt = i;
      if (this.qwV != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.qwV);
      }
      i = paramInt + f.a.a.a.c(11, 8, this.EtT) + f.a.a.b.b.a.bA(12, this.yMc) + f.a.a.b.b.a.bA(13, this.cJR);
      paramInt = i;
      if (this.AGg != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.AGg);
      }
      i = paramInt + f.a.a.b.b.a.bA(15, this.EtU);
      paramInt = i;
      if (this.EtV != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.EtV);
      }
      i = paramInt;
      if (this.qGK != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.qGK);
      }
      paramInt = i;
      if (this.EtW != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.EtW);
      }
      i = paramInt + f.a.a.a.c(19, 1, this.EtX) + f.a.a.b.b.a.bA(20, this.svd);
      paramInt = i;
      if (this.EtY != null) {
        paramInt = i + f.a.a.a.kW(21, this.EtY.computeSize());
      }
      AppMethodBeat.o(152997);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.AFX.clear();
        this.EtT.clear();
        this.EtX.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152997);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dcn localdcn = (dcn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152997);
          return -1;
        case 1: 
          localdcn.jko = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 2: 
          localdcn.sessionId = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 3: 
          localdcn.dtw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 4: 
          localdcn.offset = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152997);
          return 0;
        case 5: 
          localdcn.dcm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 6: 
          localdcn.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152997);
          return 0;
        case 7: 
          localdcn.url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 8: 
          localdcn.dnB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdcn.AFX.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152997);
          return 0;
        case 10: 
          localdcn.qwV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdcn.EtT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152997);
          return 0;
        case 12: 
          localdcn.yMc = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152997);
          return 0;
        case 13: 
          localdcn.cJR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152997);
          return 0;
        case 14: 
          localdcn.AGg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 15: 
          localdcn.EtU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152997);
          return 0;
        case 16: 
          localdcn.EtV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 17: 
          localdcn.qGK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 18: 
          localdcn.EtW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 19: 
          localdcn.EtX.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(152997);
          return 0;
        case 20: 
          localdcn.svd = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152997);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new amb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((amb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdcn.EtY = ((amb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152997);
        return 0;
      }
      AppMethodBeat.o(152997);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcn
 * JD-Core Version:    0.7.0.1
 */