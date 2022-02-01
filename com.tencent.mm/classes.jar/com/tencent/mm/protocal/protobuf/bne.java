package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bne
  extends com.tencent.mm.cd.a
{
  public int SLe;
  public String SYf;
  public int SYg;
  public bns SYh;
  public int SYi;
  public fit SYj;
  public int SYk;
  public String app_id;
  public int app_status;
  public String iUJ;
  public String ufB;
  public String ufC;
  public String ufq;
  public long ufr;
  public String ufs;
  public int ufu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205948);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.app_id != null) {
        paramVarArgs.f(1, this.app_id);
      }
      if (this.ufB != null) {
        paramVarArgs.f(2, this.ufB);
      }
      if (this.ufC != null) {
        paramVarArgs.f(3, this.ufC);
      }
      if (this.iUJ != null) {
        paramVarArgs.f(4, this.iUJ);
      }
      if (this.ufq != null) {
        paramVarArgs.f(5, this.ufq);
      }
      paramVarArgs.bm(6, this.ufr);
      if (this.ufs != null) {
        paramVarArgs.f(7, this.ufs);
      }
      paramVarArgs.aY(8, this.ufu);
      paramVarArgs.aY(9, this.app_status);
      if (this.SYf != null) {
        paramVarArgs.f(10, this.SYf);
      }
      paramVarArgs.aY(11, this.SYg);
      if (this.SYh != null)
      {
        paramVarArgs.oE(12, this.SYh.computeSize());
        this.SYh.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(13, this.SLe);
      paramVarArgs.aY(14, this.SYi);
      if (this.SYj != null)
      {
        paramVarArgs.oE(15, this.SYj.computeSize());
        this.SYj.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(16, this.SYk);
      AppMethodBeat.o(205948);
      return 0;
    }
    if (paramInt == 1) {
      if (this.app_id == null) {
        break label1166;
      }
    }
    label1166:
    for (int i = g.a.a.b.b.a.g(1, this.app_id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ufB != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ufB);
      }
      i = paramInt;
      if (this.ufC != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ufC);
      }
      paramInt = i;
      if (this.iUJ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.iUJ);
      }
      i = paramInt;
      if (this.ufq != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.ufq);
      }
      i += g.a.a.b.b.a.p(6, this.ufr);
      paramInt = i;
      if (this.ufs != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.ufs);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.ufu) + g.a.a.b.b.a.bM(9, this.app_status);
      paramInt = i;
      if (this.SYf != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.SYf);
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.SYg);
      paramInt = i;
      if (this.SYh != null) {
        paramInt = i + g.a.a.a.oD(12, this.SYh.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.SLe) + g.a.a.b.b.a.bM(14, this.SYi);
      paramInt = i;
      if (this.SYj != null) {
        paramInt = i + g.a.a.a.oD(15, this.SYj.computeSize());
      }
      i = g.a.a.b.b.a.bM(16, this.SYk);
      AppMethodBeat.o(205948);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205948);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bne localbne = (bne)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(205948);
          return -1;
        case 1: 
          localbne.app_id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(205948);
          return 0;
        case 2: 
          localbne.ufB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(205948);
          return 0;
        case 3: 
          localbne.ufC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(205948);
          return 0;
        case 4: 
          localbne.iUJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(205948);
          return 0;
        case 5: 
          localbne.ufq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(205948);
          return 0;
        case 6: 
          localbne.ufr = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(205948);
          return 0;
        case 7: 
          localbne.ufs = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(205948);
          return 0;
        case 8: 
          localbne.ufu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(205948);
          return 0;
        case 9: 
          localbne.app_status = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(205948);
          return 0;
        case 10: 
          localbne.SYf = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(205948);
          return 0;
        case 11: 
          localbne.SYg = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(205948);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bns();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bns)localObject2).parseFrom((byte[])localObject1);
            }
            localbne.SYh = ((bns)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(205948);
          return 0;
        case 13: 
          localbne.SLe = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(205948);
          return 0;
        case 14: 
          localbne.SYi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(205948);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fit();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fit)localObject2).parseFrom((byte[])localObject1);
            }
            localbne.SYj = ((fit)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(205948);
          return 0;
        }
        localbne.SYk = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(205948);
        return 0;
      }
      AppMethodBeat.o(205948);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bne
 * JD-Core Version:    0.7.0.1
 */