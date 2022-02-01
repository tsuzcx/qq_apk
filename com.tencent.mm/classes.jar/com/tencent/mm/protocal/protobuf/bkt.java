package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bkt
  extends cwj
{
  public LinkedList<ats> FNC;
  public LinkedList<djl> FOl;
  public String GXW;
  public ekq GXX;
  public LinkedList<eks> GXY;
  public LinkedList<ekr> GXZ;
  public LinkedList<String> GYa;
  public String GYb;
  public String GYc;
  public LinkedList<re> GYd;
  public boolean GYe;
  public boolean qlD;
  public String qlt;
  public String qlu;
  public int qse;
  public String source;
  
  public bkt()
  {
    AppMethodBeat.i(32279);
    this.GXY = new LinkedList();
    this.GXZ = new LinkedList();
    this.GYa = new LinkedList();
    this.FOl = new LinkedList();
    this.FNC = new LinkedList();
    this.GYd = new LinkedList();
    AppMethodBeat.o(32279);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32280);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.GXW == null)
      {
        paramVarArgs = new b("Not all required fields were included: coverurl");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.qlu == null)
      {
        paramVarArgs = new b("Not all required fields were included: motto");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.GXX == null)
      {
        paramVarArgs = new b("Not all required fields were included: rankdesc");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GXW != null) {
        paramVarArgs.d(2, this.GXW);
      }
      if (this.qlu != null) {
        paramVarArgs.d(3, this.qlu);
      }
      if (this.GXX != null)
      {
        paramVarArgs.lJ(4, this.GXX.computeSize());
        this.GXX.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.GXY);
      paramVarArgs.e(6, 8, this.GXZ);
      if (this.source != null) {
        paramVarArgs.d(7, this.source);
      }
      paramVarArgs.e(8, 1, this.GYa);
      if (this.GYb != null) {
        paramVarArgs.d(9, this.GYb);
      }
      if (this.GYc != null) {
        paramVarArgs.d(10, this.GYc);
      }
      paramVarArgs.e(14, 8, this.FOl);
      paramVarArgs.e(15, 8, this.FNC);
      paramVarArgs.bC(16, this.qlD);
      paramVarArgs.e(17, 8, this.GYd);
      paramVarArgs.bC(18, this.GYe);
      paramVarArgs.aS(19, this.qse);
      if (this.qlt != null) {
        paramVarArgs.d(20, this.qlt);
      }
      AppMethodBeat.o(32280);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1949;
      }
    }
    label1949:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GXW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GXW);
      }
      i = paramInt;
      if (this.qlu != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.qlu);
      }
      paramInt = i;
      if (this.GXX != null) {
        paramInt = i + f.a.a.a.lI(4, this.GXX.computeSize());
      }
      i = paramInt + f.a.a.a.c(5, 8, this.GXY) + f.a.a.a.c(6, 8, this.GXZ);
      paramInt = i;
      if (this.source != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.source);
      }
      i = paramInt + f.a.a.a.c(8, 1, this.GYa);
      paramInt = i;
      if (this.GYb != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GYb);
      }
      i = paramInt;
      if (this.GYc != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.GYc);
      }
      i = i + f.a.a.a.c(14, 8, this.FOl) + f.a.a.a.c(15, 8, this.FNC) + f.a.a.b.b.a.amF(16) + f.a.a.a.c(17, 8, this.GYd) + f.a.a.b.b.a.amF(18) + f.a.a.b.b.a.bz(19, this.qse);
      paramInt = i;
      if (this.qlt != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.qlt);
      }
      AppMethodBeat.o(32280);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GXY.clear();
        this.GXZ.clear();
        this.GYa.clear();
        this.FOl.clear();
        this.FNC.clear();
        this.GYd.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        if (this.GXW == null)
        {
          paramVarArgs = new b("Not all required fields were included: coverurl");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        if (this.qlu == null)
        {
          paramVarArgs = new b("Not all required fields were included: motto");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        if (this.GXX == null)
        {
          paramVarArgs = new b("Not all required fields were included: rankdesc");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32280);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bkt localbkt = (bkt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 11: 
        case 12: 
        case 13: 
        default: 
          AppMethodBeat.o(32280);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 2: 
          localbkt.GXW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 3: 
          localbkt.qlu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ekq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ekq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkt.GXX = ((ekq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eks();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eks)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkt.GXY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ekr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ekr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkt.GXZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 7: 
          localbkt.source = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 8: 
          localbkt.GYa.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(32280);
          return 0;
        case 9: 
          localbkt.GYb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 10: 
          localbkt.GYc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new djl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((djl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkt.FOl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ats();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ats)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkt.FNC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 16: 
          localbkt.qlD = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(32280);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new re();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((re)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkt.GYd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 18: 
          localbkt.GYe = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(32280);
          return 0;
        case 19: 
          localbkt.qse = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32280);
          return 0;
        }
        localbkt.qlt = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32280);
        return 0;
      }
      AppMethodBeat.o(32280);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkt
 * JD-Core Version:    0.7.0.1
 */