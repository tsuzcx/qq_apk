package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfu
  extends com.tencent.mm.bx.a
{
  public int CJm;
  public String DDg;
  public bfv DDh;
  public String DDi;
  public int DDj;
  public int DDk;
  public long DDl;
  public String DDm;
  public String DDn;
  public int DDo;
  public String DDp;
  public String DDq;
  public String DDr;
  public String DDs;
  public String DDt;
  public int DDu;
  public String DDv;
  public String Daf;
  public long Dyw;
  public int cGx;
  public int gGU;
  public int subType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91520);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DDg != null) {
        paramVarArgs.d(1, this.DDg);
      }
      paramVarArgs.aR(2, this.subType);
      if (this.Daf != null) {
        paramVarArgs.d(3, this.Daf);
      }
      if (this.DDh != null)
      {
        paramVarArgs.kX(4, this.DDh.computeSize());
        this.DDh.writeFields(paramVarArgs);
      }
      if (this.DDi != null) {
        paramVarArgs.d(5, this.DDi);
      }
      paramVarArgs.aR(6, this.DDj);
      paramVarArgs.aR(7, this.DDk);
      paramVarArgs.aG(8, this.DDl);
      paramVarArgs.aR(9, this.gGU);
      paramVarArgs.aR(10, this.CJm);
      if (this.DDm != null) {
        paramVarArgs.d(11, this.DDm);
      }
      if (this.DDn != null) {
        paramVarArgs.d(12, this.DDn);
      }
      paramVarArgs.aR(13, this.DDo);
      if (this.DDp != null) {
        paramVarArgs.d(14, this.DDp);
      }
      if (this.DDq != null) {
        paramVarArgs.d(15, this.DDq);
      }
      if (this.DDr != null) {
        paramVarArgs.d(16, this.DDr);
      }
      if (this.DDs != null) {
        paramVarArgs.d(17, this.DDs);
      }
      if (this.DDt != null) {
        paramVarArgs.d(18, this.DDt);
      }
      paramVarArgs.aR(19, this.DDu);
      paramVarArgs.aG(20, this.Dyw);
      paramVarArgs.aR(21, this.cGx);
      if (this.DDv != null) {
        paramVarArgs.d(22, this.DDv);
      }
      AppMethodBeat.o(91520);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DDg == null) {
        break label1434;
      }
    }
    label1434:
    for (paramInt = f.a.a.b.b.a.e(1, this.DDg) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.subType);
      paramInt = i;
      if (this.Daf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Daf);
      }
      i = paramInt;
      if (this.DDh != null) {
        i = paramInt + f.a.a.a.kW(4, this.DDh.computeSize());
      }
      paramInt = i;
      if (this.DDi != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DDi);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.DDj) + f.a.a.b.b.a.bA(7, this.DDk) + f.a.a.b.b.a.q(8, this.DDl) + f.a.a.b.b.a.bA(9, this.gGU) + f.a.a.b.b.a.bA(10, this.CJm);
      paramInt = i;
      if (this.DDm != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.DDm);
      }
      i = paramInt;
      if (this.DDn != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.DDn);
      }
      i += f.a.a.b.b.a.bA(13, this.DDo);
      paramInt = i;
      if (this.DDp != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.DDp);
      }
      i = paramInt;
      if (this.DDq != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.DDq);
      }
      paramInt = i;
      if (this.DDr != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.DDr);
      }
      i = paramInt;
      if (this.DDs != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.DDs);
      }
      paramInt = i;
      if (this.DDt != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.DDt);
      }
      i = paramInt + f.a.a.b.b.a.bA(19, this.DDu) + f.a.a.b.b.a.q(20, this.Dyw) + f.a.a.b.b.a.bA(21, this.cGx);
      paramInt = i;
      if (this.DDv != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.DDv);
      }
      AppMethodBeat.o(91520);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91520);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bfu localbfu = (bfu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91520);
          return -1;
        case 1: 
          localbfu.DDg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 2: 
          localbfu.subType = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91520);
          return 0;
        case 3: 
          localbfu.Daf = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bfv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbfu.DDh = ((bfv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91520);
          return 0;
        case 5: 
          localbfu.DDi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 6: 
          localbfu.DDj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91520);
          return 0;
        case 7: 
          localbfu.DDk = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91520);
          return 0;
        case 8: 
          localbfu.DDl = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91520);
          return 0;
        case 9: 
          localbfu.gGU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91520);
          return 0;
        case 10: 
          localbfu.CJm = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91520);
          return 0;
        case 11: 
          localbfu.DDm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 12: 
          localbfu.DDn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 13: 
          localbfu.DDo = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91520);
          return 0;
        case 14: 
          localbfu.DDp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 15: 
          localbfu.DDq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 16: 
          localbfu.DDr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 17: 
          localbfu.DDs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 18: 
          localbfu.DDt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 19: 
          localbfu.DDu = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91520);
          return 0;
        case 20: 
          localbfu.Dyw = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91520);
          return 0;
        case 21: 
          localbfu.cGx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91520);
          return 0;
        }
        localbfu.DDv = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91520);
        return 0;
      }
      AppMethodBeat.o(91520);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfu
 * JD-Core Version:    0.7.0.1
 */