package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dbv
  extends cqk
{
  public LinkedList<SnsObject> DXh;
  public int FJN;
  public LinkedList<dbx> FJO;
  public String FJm;
  public int FJq;
  public dbd FJs;
  public int FKH;
  public int FLe;
  public long FLf;
  public long FLg;
  public String FLh;
  public boolean FLi;
  public dbt Few;
  public int Fli;
  
  public dbv()
  {
    AppMethodBeat.i(125836);
    this.DXh = new LinkedList();
    this.FJO = new LinkedList();
    AppMethodBeat.o(125836);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125837);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125837);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FJm != null) {
        paramVarArgs.d(2, this.FJm);
      }
      paramVarArgs.aR(3, this.Fli);
      paramVarArgs.e(4, 8, this.DXh);
      paramVarArgs.aR(5, this.FLe);
      if (this.Few != null)
      {
        paramVarArgs.ln(6, this.Few.computeSize());
        this.Few.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.FKH);
      paramVarArgs.aR(8, this.FJq);
      if (this.FJs != null)
      {
        paramVarArgs.ln(9, this.FJs.computeSize());
        this.FJs.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(10, this.FLf);
      paramVarArgs.aO(11, this.FLg);
      if (this.FLh != null) {
        paramVarArgs.d(12, this.FLh);
      }
      paramVarArgs.aR(13, this.FJN);
      paramVarArgs.e(14, 8, this.FJO);
      paramVarArgs.bl(15, this.FLi);
      AppMethodBeat.o(125837);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1434;
      }
    }
    label1434:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FJm != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FJm);
      }
      i = i + f.a.a.b.b.a.bx(3, this.Fli) + f.a.a.a.c(4, 8, this.DXh) + f.a.a.b.b.a.bx(5, this.FLe);
      paramInt = i;
      if (this.Few != null) {
        paramInt = i + f.a.a.a.lm(6, this.Few.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.FKH) + f.a.a.b.b.a.bx(8, this.FJq);
      paramInt = i;
      if (this.FJs != null) {
        paramInt = i + f.a.a.a.lm(9, this.FJs.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.p(10, this.FLf) + f.a.a.b.b.a.p(11, this.FLg);
      paramInt = i;
      if (this.FLh != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FLh);
      }
      i = f.a.a.b.b.a.bx(13, this.FJN);
      int j = f.a.a.a.c(14, 8, this.FJO);
      int k = f.a.a.b.b.a.fK(15);
      AppMethodBeat.o(125837);
      return paramInt + i + j + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DXh.clear();
        this.FJO.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125837);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125837);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dbv localdbv = (dbv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125837);
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
            localdbv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 2: 
          localdbv.FJm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125837);
          return 0;
        case 3: 
          localdbv.Fli = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125837);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SnsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbv.DXh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 5: 
          localdbv.FLe = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125837);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbv.Few = ((dbt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 7: 
          localdbv.FKH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125837);
          return 0;
        case 8: 
          localdbv.FJq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125837);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbv.FJs = ((dbd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 10: 
          localdbv.FLf = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125837);
          return 0;
        case 11: 
          localdbv.FLg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125837);
          return 0;
        case 12: 
          localdbv.FLh = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125837);
          return 0;
        case 13: 
          localdbv.FJN = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125837);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbv.FJO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        }
        localdbv.FLi = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(125837);
        return 0;
      }
      AppMethodBeat.o(125837);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbv
 * JD-Core Version:    0.7.0.1
 */