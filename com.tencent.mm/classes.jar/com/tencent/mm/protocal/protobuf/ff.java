package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ff
  extends cvc
{
  public int FwE;
  public int FwF;
  public int Fxf;
  public int Fxg;
  public long Fxh;
  public long Fxi;
  public pj Fxj;
  public int Fxk;
  public int Fxl;
  public int Fxm;
  public String Fxn;
  public String hzm;
  public int nettype;
  public int scene;
  public String session_id;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103194);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.hzm != null) {
        paramVarArgs.d(3, this.hzm);
      }
      paramVarArgs.aS(4, this.scene);
      paramVarArgs.aS(5, this.FwF);
      paramVarArgs.aS(6, this.nettype);
      if (this.session_id != null) {
        paramVarArgs.d(7, this.session_id);
      }
      paramVarArgs.aS(8, this.FwE);
      paramVarArgs.aS(9, this.Fxf);
      paramVarArgs.aS(10, this.Fxg);
      paramVarArgs.aY(11, this.Fxh);
      paramVarArgs.aY(12, this.Fxi);
      if (this.Fxj != null)
      {
        paramVarArgs.lC(13, this.Fxj.computeSize());
        this.Fxj.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(14, this.Fxk);
      paramVarArgs.aS(15, this.Fxl);
      paramVarArgs.aS(16, this.Fxm);
      if (this.Fxn != null) {
        paramVarArgs.d(17, this.Fxn);
      }
      AppMethodBeat.o(103194);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1198;
      }
    }
    label1198:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.hzm != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hzm);
      }
      i = i + f.a.a.b.b.a.bz(4, this.scene) + f.a.a.b.b.a.bz(5, this.FwF) + f.a.a.b.b.a.bz(6, this.nettype);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.session_id);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.FwE) + f.a.a.b.b.a.bz(9, this.Fxf) + f.a.a.b.b.a.bz(10, this.Fxg) + f.a.a.b.b.a.p(11, this.Fxh) + f.a.a.b.b.a.p(12, this.Fxi);
      paramInt = i;
      if (this.Fxj != null) {
        paramInt = i + f.a.a.a.lB(13, this.Fxj.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(14, this.Fxk) + f.a.a.b.b.a.bz(15, this.Fxl) + f.a.a.b.b.a.bz(16, this.Fxm);
      paramInt = i;
      if (this.Fxn != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.Fxn);
      }
      AppMethodBeat.o(103194);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(103194);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ff localff = (ff)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(103194);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localff.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103194);
          return 0;
        case 2: 
          localff.url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(103194);
          return 0;
        case 3: 
          localff.hzm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(103194);
          return 0;
        case 4: 
          localff.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103194);
          return 0;
        case 5: 
          localff.FwF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103194);
          return 0;
        case 6: 
          localff.nettype = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103194);
          return 0;
        case 7: 
          localff.session_id = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(103194);
          return 0;
        case 8: 
          localff.FwE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103194);
          return 0;
        case 9: 
          localff.Fxf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103194);
          return 0;
        case 10: 
          localff.Fxg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103194);
          return 0;
        case 11: 
          localff.Fxh = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(103194);
          return 0;
        case 12: 
          localff.Fxi = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(103194);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localff.Fxj = ((pj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103194);
          return 0;
        case 14: 
          localff.Fxk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103194);
          return 0;
        case 15: 
          localff.Fxl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103194);
          return 0;
        case 16: 
          localff.Fxm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103194);
          return 0;
        }
        localff.Fxn = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(103194);
        return 0;
      }
      AppMethodBeat.o(103194);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ff
 * JD-Core Version:    0.7.0.1
 */