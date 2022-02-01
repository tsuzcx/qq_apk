package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public String IKJ;
  public String MEX;
  public double MEY;
  public String MEZ;
  public String MFa;
  public int MFb;
  public String MFc;
  public int MFd;
  public int MFe;
  public String MFf;
  public String MFg;
  public String MFh;
  public String MFi;
  public String MFj;
  public int MFk;
  public LinkedList<k> MFl;
  public String MFm;
  public String MFn;
  public double MFo;
  public String MFp;
  
  public i()
  {
    AppMethodBeat.i(91261);
    this.MFl = new LinkedList();
    AppMethodBeat.o(91261);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91262);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.MEX != null) {
        paramVarArgs.g(1, this.MEX);
      }
      paramVarArgs.d(2, this.MEY);
      if (this.MEZ != null) {
        paramVarArgs.g(3, this.MEZ);
      }
      paramVarArgs.bS(4, this.CreateTime);
      if (this.MFa != null) {
        paramVarArgs.g(5, this.MFa);
      }
      paramVarArgs.bS(6, this.MFb);
      if (this.MFc != null) {
        paramVarArgs.g(7, this.MFc);
      }
      paramVarArgs.bS(8, this.MFd);
      paramVarArgs.bS(9, this.MFe);
      if (this.MFf != null) {
        paramVarArgs.g(10, this.MFf);
      }
      if (this.IKJ != null) {
        paramVarArgs.g(11, this.IKJ);
      }
      if (this.MFg != null) {
        paramVarArgs.g(12, this.MFg);
      }
      if (this.MFh != null) {
        paramVarArgs.g(13, this.MFh);
      }
      if (this.MFi != null) {
        paramVarArgs.g(14, this.MFi);
      }
      if (this.MFj != null) {
        paramVarArgs.g(15, this.MFj);
      }
      paramVarArgs.bS(16, this.MFk);
      paramVarArgs.e(17, 8, this.MFl);
      if (this.MFm != null) {
        paramVarArgs.g(18, this.MFm);
      }
      if (this.MFn != null) {
        paramVarArgs.g(19, this.MFn);
      }
      paramVarArgs.d(20, this.MFo);
      if (this.MFp != null) {
        paramVarArgs.g(21, this.MFp);
      }
      AppMethodBeat.o(91262);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MEX == null) {
        break label1394;
      }
    }
    label1394:
    for (paramInt = i.a.a.b.b.a.h(1, this.MEX) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 8);
      paramInt = i;
      if (this.MEZ != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.MEZ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.CreateTime);
      paramInt = i;
      if (this.MFa != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.MFa);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.MFb);
      paramInt = i;
      if (this.MFc != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.MFc);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.MFd) + i.a.a.b.b.a.cJ(9, this.MFe);
      paramInt = i;
      if (this.MFf != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.MFf);
      }
      i = paramInt;
      if (this.IKJ != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.IKJ);
      }
      paramInt = i;
      if (this.MFg != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.MFg);
      }
      i = paramInt;
      if (this.MFh != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.MFh);
      }
      paramInt = i;
      if (this.MFi != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.MFi);
      }
      i = paramInt;
      if (this.MFj != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.MFj);
      }
      i = i + i.a.a.b.b.a.cJ(16, this.MFk) + i.a.a.a.c(17, 8, this.MFl);
      paramInt = i;
      if (this.MFm != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.MFm);
      }
      i = paramInt;
      if (this.MFn != null) {
        i = paramInt + i.a.a.b.b.a.h(19, this.MFn);
      }
      i += i.a.a.b.b.a.ko(20) + 8;
      paramInt = i;
      if (this.MFp != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.MFp);
      }
      AppMethodBeat.o(91262);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MFl.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91262);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        i locali = (i)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91262);
          return -1;
        case 1: 
          locali.MEX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 2: 
          locali.MEY = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
          AppMethodBeat.o(91262);
          return 0;
        case 3: 
          locali.MEZ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 4: 
          locali.CreateTime = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91262);
          return 0;
        case 5: 
          locali.MFa = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 6: 
          locali.MFb = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91262);
          return 0;
        case 7: 
          locali.MFc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 8: 
          locali.MFd = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91262);
          return 0;
        case 9: 
          locali.MFe = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91262);
          return 0;
        case 10: 
          locali.MFf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 11: 
          locali.IKJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 12: 
          locali.MFg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 13: 
          locali.MFh = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 14: 
          locali.MFi = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 15: 
          locali.MFj = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 16: 
          locali.MFk = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91262);
          return 0;
        case 17: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            k localk = new k();
            if ((localObject != null) && (localObject.length > 0)) {
              localk.parseFrom((byte[])localObject);
            }
            locali.MFl.add(localk);
            paramInt += 1;
          }
          AppMethodBeat.o(91262);
          return 0;
        case 18: 
          locali.MFm = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 19: 
          locali.MFn = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 20: 
          locali.MFo = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
          AppMethodBeat.o(91262);
          return 0;
        }
        locali.MFp = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91262);
        return 0;
      }
      AppMethodBeat.o(91262);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.i
 * JD-Core Version:    0.7.0.1
 */