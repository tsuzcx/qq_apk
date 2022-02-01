package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bfv
  extends cqk
{
  public LinkedList<api> DPP;
  public LinkedList<String> EVa;
  public String EVb;
  public String EVc;
  public boolean EVe;
  public LinkedList<ecr> EVh;
  public LinkedList<ecs> EVi;
  public String EVj;
  public String EVk;
  public String EVl;
  public String EVm;
  public boolean EVn;
  public int EVo;
  public String EVp;
  public String hip;
  public boolean pBG;
  
  public bfv()
  {
    AppMethodBeat.i(32282);
    this.EVh = new LinkedList();
    this.EVi = new LinkedList();
    this.EVa = new LinkedList();
    this.DPP = new LinkedList();
    AppMethodBeat.o(32282);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32283);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.EVj == null)
      {
        paramVarArgs = new b("Not all required fields were included: championcoverurl");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.EVk == null)
      {
        paramVarArgs = new b("Not all required fields were included: championmotto");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.hip == null)
      {
        paramVarArgs = new b("Not all required fields were included: rankid");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.EVh);
      paramVarArgs.e(3, 8, this.EVi);
      paramVarArgs.e(4, 1, this.EVa);
      if (this.EVj != null) {
        paramVarArgs.d(5, this.EVj);
      }
      if (this.EVk != null) {
        paramVarArgs.d(6, this.EVk);
      }
      if (this.hip != null) {
        paramVarArgs.d(7, this.hip);
      }
      if (this.EVl != null) {
        paramVarArgs.d(8, this.EVl);
      }
      if (this.EVb != null) {
        paramVarArgs.d(9, this.EVb);
      }
      paramVarArgs.bl(10, this.pBG);
      if (this.EVc != null) {
        paramVarArgs.d(11, this.EVc);
      }
      paramVarArgs.e(12, 8, this.DPP);
      paramVarArgs.bl(13, this.EVe);
      if (this.EVm != null) {
        paramVarArgs.d(14, this.EVm);
      }
      paramVarArgs.bl(15, this.EVn);
      paramVarArgs.aR(16, this.EVo);
      if (this.EVp != null) {
        paramVarArgs.d(17, this.EVp);
      }
      AppMethodBeat.o(32283);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1677;
      }
    }
    label1677:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.EVh) + f.a.a.a.c(3, 8, this.EVi) + f.a.a.a.c(4, 1, this.EVa);
      paramInt = i;
      if (this.EVj != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EVj);
      }
      i = paramInt;
      if (this.EVk != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.EVk);
      }
      paramInt = i;
      if (this.hip != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hip);
      }
      i = paramInt;
      if (this.EVl != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.EVl);
      }
      paramInt = i;
      if (this.EVb != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.EVb);
      }
      i = paramInt + (f.a.a.b.b.a.fK(10) + 1);
      paramInt = i;
      if (this.EVc != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.EVc);
      }
      i = paramInt + f.a.a.a.c(12, 8, this.DPP) + (f.a.a.b.b.a.fK(13) + 1);
      paramInt = i;
      if (this.EVm != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.EVm);
      }
      i = paramInt + (f.a.a.b.b.a.fK(15) + 1) + f.a.a.b.b.a.bx(16, this.EVo);
      paramInt = i;
      if (this.EVp != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.EVp);
      }
      AppMethodBeat.o(32283);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EVh.clear();
        this.EVi.clear();
        this.EVa.clear();
        this.DPP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        if (this.EVj == null)
        {
          paramVarArgs = new b("Not all required fields were included: championcoverurl");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        if (this.EVk == null)
        {
          paramVarArgs = new b("Not all required fields were included: championmotto");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        if (this.hip == null)
        {
          paramVarArgs = new b("Not all required fields were included: rankid");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32283);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bfv localbfv = (bfv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32283);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbfv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbfv.EVh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbfv.EVi.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 4: 
          localbfv.EVa.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(32283);
          return 0;
        case 5: 
          localbfv.EVj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 6: 
          localbfv.EVk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 7: 
          localbfv.hip = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 8: 
          localbfv.EVl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 9: 
          localbfv.EVb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 10: 
          localbfv.pBG = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(32283);
          return 0;
        case 11: 
          localbfv.EVc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new api();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((api)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbfv.DPP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 13: 
          localbfv.EVe = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(32283);
          return 0;
        case 14: 
          localbfv.EVm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 15: 
          localbfv.EVn = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(32283);
          return 0;
        case 16: 
          localbfv.EVo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32283);
          return 0;
        }
        localbfv.EVp = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32283);
        return 0;
      }
      AppMethodBeat.o(32283);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfv
 * JD-Core Version:    0.7.0.1
 */