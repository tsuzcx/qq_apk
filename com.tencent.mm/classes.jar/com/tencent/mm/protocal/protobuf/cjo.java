package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjo
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public int Hdr;
  public String uiR;
  public String wDA;
  public int wDB;
  public LinkedList<den> wDC;
  public String wDo;
  public String wDq;
  public String wDr;
  public int wDs;
  public String wDt;
  public int wDu;
  public int wDv;
  public String wDw;
  public String wDx;
  public String wDy;
  public String wDz;
  
  public cjo()
  {
    AppMethodBeat.i(91596);
    this.wDC = new LinkedList();
    AppMethodBeat.o(91596);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91597);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wDo != null) {
        paramVarArgs.d(1, this.wDo);
      }
      paramVarArgs.aS(2, this.Hdr);
      if (this.wDq != null) {
        paramVarArgs.d(3, this.wDq);
      }
      paramVarArgs.aS(4, this.CreateTime);
      if (this.wDr != null) {
        paramVarArgs.d(5, this.wDr);
      }
      paramVarArgs.aS(6, this.wDs);
      if (this.wDt != null) {
        paramVarArgs.d(7, this.wDt);
      }
      paramVarArgs.aS(8, this.wDu);
      paramVarArgs.aS(9, this.wDv);
      if (this.wDw != null) {
        paramVarArgs.d(10, this.wDw);
      }
      if (this.uiR != null) {
        paramVarArgs.d(11, this.uiR);
      }
      if (this.wDx != null) {
        paramVarArgs.d(12, this.wDx);
      }
      if (this.wDy != null) {
        paramVarArgs.d(13, this.wDy);
      }
      if (this.wDz != null) {
        paramVarArgs.d(14, this.wDz);
      }
      if (this.wDA != null) {
        paramVarArgs.d(15, this.wDA);
      }
      paramVarArgs.aS(16, this.wDB);
      paramVarArgs.e(17, 8, this.wDC);
      AppMethodBeat.o(91597);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wDo == null) {
        break label1186;
      }
    }
    label1186:
    for (paramInt = f.a.a.b.b.a.e(1, this.wDo) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Hdr);
      paramInt = i;
      if (this.wDq != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.wDq);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.CreateTime);
      paramInt = i;
      if (this.wDr != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.wDr);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.wDs);
      paramInt = i;
      if (this.wDt != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.wDt);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.wDu) + f.a.a.b.b.a.bz(9, this.wDv);
      paramInt = i;
      if (this.wDw != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.wDw);
      }
      i = paramInt;
      if (this.uiR != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.uiR);
      }
      paramInt = i;
      if (this.wDx != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.wDx);
      }
      i = paramInt;
      if (this.wDy != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.wDy);
      }
      paramInt = i;
      if (this.wDz != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.wDz);
      }
      i = paramInt;
      if (this.wDA != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.wDA);
      }
      paramInt = f.a.a.b.b.a.bz(16, this.wDB);
      int j = f.a.a.a.c(17, 8, this.wDC);
      AppMethodBeat.o(91597);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wDC.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91597);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjo localcjo = (cjo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91597);
          return -1;
        case 1: 
          localcjo.wDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 2: 
          localcjo.Hdr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91597);
          return 0;
        case 3: 
          localcjo.wDq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 4: 
          localcjo.CreateTime = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91597);
          return 0;
        case 5: 
          localcjo.wDr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 6: 
          localcjo.wDs = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91597);
          return 0;
        case 7: 
          localcjo.wDt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 8: 
          localcjo.wDu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91597);
          return 0;
        case 9: 
          localcjo.wDv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91597);
          return 0;
        case 10: 
          localcjo.wDw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 11: 
          localcjo.uiR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 12: 
          localcjo.wDx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 13: 
          localcjo.wDy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 14: 
          localcjo.wDz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 15: 
          localcjo.wDA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 16: 
          localcjo.wDB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91597);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new den();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((den)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcjo.wDC.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91597);
        return 0;
      }
      AppMethodBeat.o(91597);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjo
 * JD-Core Version:    0.7.0.1
 */