package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public class ash
  extends cvw
{
  public alw GDR;
  public alz GDS;
  public LinkedList<byu> GGB;
  public LinkedList<dje> GIA;
  public b GIF;
  public int GJg;
  public long GJh;
  public String GJi;
  public long GJj;
  public LinkedList<asz> GJk;
  public int GJl;
  public String GJm;
  public float dBu;
  public int dvm;
  public float dzE;
  public b lastBuffer;
  public int pullType;
  public String sbR;
  public String sessionId;
  
  public ash()
  {
    AppMethodBeat.i(184211);
    this.GGB = new LinkedList();
    this.GIA = new LinkedList();
    this.GJk = new LinkedList();
    AppMethodBeat.o(184211);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169056);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      if (this.sbR != null) {
        paramVarArgs.d(4, this.sbR);
      }
      paramVarArgs.aS(5, this.pullType);
      if (this.GDR != null)
      {
        paramVarArgs.lJ(6, this.GDR.computeSize());
        this.GDR.writeFields(paramVarArgs);
      }
      paramVarArgs.y(7, this.dBu);
      paramVarArgs.y(8, this.dzE);
      if (this.sessionId != null) {
        paramVarArgs.d(9, this.sessionId);
      }
      if (this.GDS != null)
      {
        paramVarArgs.lJ(10, this.GDS.computeSize());
        this.GDS.writeFields(paramVarArgs);
      }
      paramVarArgs.e(11, 8, this.GGB);
      paramVarArgs.aS(12, this.GJg);
      paramVarArgs.aS(13, this.dvm);
      paramVarArgs.aZ(14, this.GJh);
      if (this.GJi != null) {
        paramVarArgs.d(15, this.GJi);
      }
      paramVarArgs.e(16, 8, this.GIA);
      paramVarArgs.aZ(17, this.GJj);
      paramVarArgs.e(18, 8, this.GJk);
      if (this.GIF != null) {
        paramVarArgs.c(19, this.GIF);
      }
      paramVarArgs.aS(20, this.GJl);
      if (this.GJm != null) {
        paramVarArgs.d(21, this.GJm);
      }
      AppMethodBeat.o(169056);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1772;
      }
    }
    label1772:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = paramInt;
      if (this.sbR != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.sbR);
      }
      i += f.a.a.b.b.a.bz(5, this.pullType);
      paramInt = i;
      if (this.GDR != null) {
        paramInt = i + f.a.a.a.lI(6, this.GDR.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.amE(7) + f.a.a.b.b.a.amE(8);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.sessionId);
      }
      i = paramInt;
      if (this.GDS != null) {
        i = paramInt + f.a.a.a.lI(10, this.GDS.computeSize());
      }
      i = i + f.a.a.a.c(11, 8, this.GGB) + f.a.a.b.b.a.bz(12, this.GJg) + f.a.a.b.b.a.bz(13, this.dvm) + f.a.a.b.b.a.p(14, this.GJh);
      paramInt = i;
      if (this.GJi != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.GJi);
      }
      i = paramInt + f.a.a.a.c(16, 8, this.GIA) + f.a.a.b.b.a.p(17, this.GJj) + f.a.a.a.c(18, 8, this.GJk);
      paramInt = i;
      if (this.GIF != null) {
        paramInt = i + f.a.a.b.b.a.b(19, this.GIF);
      }
      i = paramInt + f.a.a.b.b.a.bz(20, this.GJl);
      paramInt = i;
      if (this.GJm != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.GJm);
      }
      AppMethodBeat.o(169056);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GGB.clear();
        this.GIA.clear();
        this.GJk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169056);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ash localash = (ash)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(169056);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localash.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 3: 
          localash.lastBuffer = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(169056);
          return 0;
        case 4: 
          localash.sbR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 5: 
          localash.pullType = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169056);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localash.GDR = ((alw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 7: 
          localash.dBu = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(169056);
          return 0;
        case 8: 
          localash.dzE = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(169056);
          return 0;
        case 9: 
          localash.sessionId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localash.GDS = ((alz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new byu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((byu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localash.GGB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 12: 
          localash.GJg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169056);
          return 0;
        case 13: 
          localash.dvm = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169056);
          return 0;
        case 14: 
          localash.GJh = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(169056);
          return 0;
        case 15: 
          localash.GJi = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dje();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dje)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localash.GIA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 17: 
          localash.GJj = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(169056);
          return 0;
        case 18: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new asz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((asz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localash.GJk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 19: 
          localash.GIF = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(169056);
          return 0;
        case 20: 
          localash.GJl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169056);
          return 0;
        }
        localash.GJm = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169056);
        return 0;
      }
      AppMethodBeat.o(169056);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ash
 * JD-Core Version:    0.7.0.1
 */