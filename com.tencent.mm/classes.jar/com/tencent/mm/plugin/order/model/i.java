package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.cd.a
{
  public String CQz;
  public int CreateTime;
  public String GIh;
  public double GIi;
  public String GIj;
  public String GIk;
  public int GIl;
  public String GIm;
  public int GIn;
  public int GIo;
  public String GIp;
  public String GIq;
  public String GIr;
  public String GIs;
  public String GIt;
  public int GIu;
  public LinkedList<k> GIv;
  public String GIw;
  public String GIx;
  public double GIy;
  public String GIz;
  
  public i()
  {
    AppMethodBeat.i(91261);
    this.GIv = new LinkedList();
    AppMethodBeat.o(91261);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91262);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.GIh != null) {
        paramVarArgs.f(1, this.GIh);
      }
      paramVarArgs.e(2, this.GIi);
      if (this.GIj != null) {
        paramVarArgs.f(3, this.GIj);
      }
      paramVarArgs.aY(4, this.CreateTime);
      if (this.GIk != null) {
        paramVarArgs.f(5, this.GIk);
      }
      paramVarArgs.aY(6, this.GIl);
      if (this.GIm != null) {
        paramVarArgs.f(7, this.GIm);
      }
      paramVarArgs.aY(8, this.GIn);
      paramVarArgs.aY(9, this.GIo);
      if (this.GIp != null) {
        paramVarArgs.f(10, this.GIp);
      }
      if (this.CQz != null) {
        paramVarArgs.f(11, this.CQz);
      }
      if (this.GIq != null) {
        paramVarArgs.f(12, this.GIq);
      }
      if (this.GIr != null) {
        paramVarArgs.f(13, this.GIr);
      }
      if (this.GIs != null) {
        paramVarArgs.f(14, this.GIs);
      }
      if (this.GIt != null) {
        paramVarArgs.f(15, this.GIt);
      }
      paramVarArgs.aY(16, this.GIu);
      paramVarArgs.e(17, 8, this.GIv);
      if (this.GIw != null) {
        paramVarArgs.f(18, this.GIw);
      }
      if (this.GIx != null) {
        paramVarArgs.f(19, this.GIx);
      }
      paramVarArgs.e(20, this.GIy);
      if (this.GIz != null) {
        paramVarArgs.f(21, this.GIz);
      }
      AppMethodBeat.o(91262);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GIh == null) {
        break label1394;
      }
    }
    label1394:
    for (paramInt = g.a.a.b.b.a.g(1, this.GIh) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.gL(2) + 8);
      paramInt = i;
      if (this.GIj != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.GIj);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.CreateTime);
      paramInt = i;
      if (this.GIk != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.GIk);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.GIl);
      paramInt = i;
      if (this.GIm != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.GIm);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.GIn) + g.a.a.b.b.a.bM(9, this.GIo);
      paramInt = i;
      if (this.GIp != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.GIp);
      }
      i = paramInt;
      if (this.CQz != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.CQz);
      }
      paramInt = i;
      if (this.GIq != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.GIq);
      }
      i = paramInt;
      if (this.GIr != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.GIr);
      }
      paramInt = i;
      if (this.GIs != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.GIs);
      }
      i = paramInt;
      if (this.GIt != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.GIt);
      }
      i = i + g.a.a.b.b.a.bM(16, this.GIu) + g.a.a.a.c(17, 8, this.GIv);
      paramInt = i;
      if (this.GIw != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.GIw);
      }
      i = paramInt;
      if (this.GIx != null) {
        i = paramInt + g.a.a.b.b.a.g(19, this.GIx);
      }
      i += g.a.a.b.b.a.gL(20) + 8;
      paramInt = i;
      if (this.GIz != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.GIz);
      }
      AppMethodBeat.o(91262);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GIv.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91262);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        i locali = (i)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91262);
          return -1;
        case 1: 
          locali.GIh = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 2: 
          locali.GIi = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
          AppMethodBeat.o(91262);
          return 0;
        case 3: 
          locali.GIj = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 4: 
          locali.CreateTime = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91262);
          return 0;
        case 5: 
          locali.GIk = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 6: 
          locali.GIl = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91262);
          return 0;
        case 7: 
          locali.GIm = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 8: 
          locali.GIn = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91262);
          return 0;
        case 9: 
          locali.GIo = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91262);
          return 0;
        case 10: 
          locali.GIp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 11: 
          locali.CQz = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 12: 
          locali.GIq = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 13: 
          locali.GIr = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 14: 
          locali.GIs = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 15: 
          locali.GIt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 16: 
          locali.GIu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91262);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            k localk = new k();
            if ((localObject != null) && (localObject.length > 0)) {
              localk.parseFrom((byte[])localObject);
            }
            locali.GIv.add(localk);
            paramInt += 1;
          }
          AppMethodBeat.o(91262);
          return 0;
        case 18: 
          locali.GIw = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 19: 
          locali.GIx = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 20: 
          locali.GIy = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
          AppMethodBeat.o(91262);
          return 0;
        }
        locali.GIz = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91262);
        return 0;
      }
      AppMethodBeat.o(91262);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.i
 * JD-Core Version:    0.7.0.1
 */