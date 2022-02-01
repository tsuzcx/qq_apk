package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bhh
  extends cpx
{
  public String EUn;
  public int EUq;
  public int EWh;
  public boolean EWi;
  public ccl EWj;
  public String EWk;
  public LinkedList<bwq> EWl;
  public int EWm;
  public boolean EWn;
  public boolean EWo;
  public int Eeo;
  public String djj;
  public String lmu;
  public String path;
  public int scene;
  public int type;
  public String username;
  
  public bhh()
  {
    AppMethodBeat.i(123586);
    this.EWi = false;
    this.EWl = new LinkedList();
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
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.type);
      if (this.djj != null) {
        paramVarArgs.d(3, this.djj);
      }
      paramVarArgs.aR(4, this.Eeo);
      if (this.lmu != null) {
        paramVarArgs.d(5, this.lmu);
      }
      paramVarArgs.aR(6, this.EUq);
      paramVarArgs.aR(7, this.EWh);
      if (this.EUn != null) {
        paramVarArgs.d(8, this.EUn);
      }
      paramVarArgs.bl(9, this.EWi);
      if (this.EWj != null)
      {
        paramVarArgs.ln(10, this.EWj.computeSize());
        this.EWj.writeFields(paramVarArgs);
      }
      if (this.EWk != null) {
        paramVarArgs.d(11, this.EWk);
      }
      paramVarArgs.e(12, 8, this.EWl);
      paramVarArgs.aR(13, this.EWm);
      if (this.username != null) {
        paramVarArgs.d(14, this.username);
      }
      if (this.path != null) {
        paramVarArgs.d(15, this.path);
      }
      paramVarArgs.bl(16, this.EWn);
      paramVarArgs.bl(17, this.EWo);
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
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.type);
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.djj);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.Eeo);
      paramInt = i;
      if (this.lmu != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.lmu);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.EUq) + f.a.a.b.b.a.bx(7, this.EWh);
      paramInt = i;
      if (this.EUn != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EUn);
      }
      i = paramInt + (f.a.a.b.b.a.fK(9) + 1);
      paramInt = i;
      if (this.EWj != null) {
        paramInt = i + f.a.a.a.lm(10, this.EWj.computeSize());
      }
      i = paramInt;
      if (this.EWk != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.EWk);
      }
      i = i + f.a.a.a.c(12, 8, this.EWl) + f.a.a.b.b.a.bx(13, this.EWm);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.username);
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.path);
      }
      paramInt = f.a.a.b.b.a.fK(16);
      int j = f.a.a.b.b.a.fK(17);
      int k = f.a.a.b.b.a.bx(18, this.scene);
      AppMethodBeat.o(123587);
      return i + (paramInt + 1) + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EWl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123587);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bhh localbhh = (bhh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123587);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhh.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123587);
          return 0;
        case 2: 
          localbhh.type = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123587);
          return 0;
        case 3: 
          localbhh.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 4: 
          localbhh.Eeo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123587);
          return 0;
        case 5: 
          localbhh.lmu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 6: 
          localbhh.EUq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123587);
          return 0;
        case 7: 
          localbhh.EWh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123587);
          return 0;
        case 8: 
          localbhh.EUn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 9: 
          localbhh.EWi = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(123587);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhh.EWj = ((ccl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123587);
          return 0;
        case 11: 
          localbhh.EWk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhh.EWl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123587);
          return 0;
        case 13: 
          localbhh.EWm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123587);
          return 0;
        case 14: 
          localbhh.username = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 15: 
          localbhh.path = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 16: 
          localbhh.EWn = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(123587);
          return 0;
        case 17: 
          localbhh.EWo = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(123587);
          return 0;
        }
        localbhh.scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(123587);
        return 0;
      }
      AppMethodBeat.o(123587);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhh
 * JD-Core Version:    0.7.0.1
 */