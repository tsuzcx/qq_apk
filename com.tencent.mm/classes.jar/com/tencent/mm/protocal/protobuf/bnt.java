package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnt
  extends com.tencent.mm.cd.a
{
  public String SYN;
  public String SYf;
  public int SYi;
  public fit SYj;
  public int app_status;
  public String appid;
  public String iUJ;
  public String lnp;
  public String ufC;
  public String ufq;
  public long ufr;
  public String ufs;
  public int ufu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231378);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.f(1, this.appid);
      }
      if (this.lnp != null) {
        paramVarArgs.f(2, this.lnp);
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
      paramVarArgs.aY(11, this.SYi);
      if (this.SYj != null)
      {
        paramVarArgs.oE(12, this.SYj.computeSize());
        this.SYj.writeFields(paramVarArgs);
      }
      if (this.SYN != null) {
        paramVarArgs.f(13, this.SYN);
      }
      AppMethodBeat.o(231378);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label960;
      }
    }
    label960:
    for (int i = g.a.a.b.b.a.g(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lnp != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.lnp);
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
      i = paramInt + g.a.a.b.b.a.bM(11, this.SYi);
      paramInt = i;
      if (this.SYj != null) {
        paramInt = i + g.a.a.a.oD(12, this.SYj.computeSize());
      }
      i = paramInt;
      if (this.SYN != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.SYN);
      }
      AppMethodBeat.o(231378);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231378);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bnt localbnt = (bnt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231378);
          return -1;
        case 1: 
          localbnt.appid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231378);
          return 0;
        case 2: 
          localbnt.lnp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231378);
          return 0;
        case 3: 
          localbnt.ufC = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231378);
          return 0;
        case 4: 
          localbnt.iUJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231378);
          return 0;
        case 5: 
          localbnt.ufq = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231378);
          return 0;
        case 6: 
          localbnt.ufr = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(231378);
          return 0;
        case 7: 
          localbnt.ufs = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231378);
          return 0;
        case 8: 
          localbnt.ufu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(231378);
          return 0;
        case 9: 
          localbnt.app_status = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(231378);
          return 0;
        case 10: 
          localbnt.SYf = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231378);
          return 0;
        case 11: 
          localbnt.SYi = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(231378);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fit localfit = new fit();
            if ((localObject != null) && (localObject.length > 0)) {
              localfit.parseFrom((byte[])localObject);
            }
            localbnt.SYj = localfit;
            paramInt += 1;
          }
          AppMethodBeat.o(231378);
          return 0;
        }
        localbnt.SYN = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(231378);
        return 0;
      }
      AppMethodBeat.o(231378);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnt
 * JD-Core Version:    0.7.0.1
 */