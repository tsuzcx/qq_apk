package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eyu
  extends com.tencent.mm.cd.a
{
  public int TGY;
  public LinkedList<eyv> UyZ;
  public String Uza;
  public int Uzb;
  public String appid;
  public int apptype;
  public String lnp;
  public String tsf;
  
  public eyu()
  {
    AppMethodBeat.i(74672);
    this.UyZ = new LinkedList();
    AppMethodBeat.o(74672);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74673);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.f(1, this.appid);
      }
      if (this.lnp != null) {
        paramVarArgs.f(2, this.lnp);
      }
      paramVarArgs.aY(3, this.apptype);
      paramVarArgs.e(4, 8, this.UyZ);
      paramVarArgs.aY(5, this.TGY);
      if (this.Uza != null) {
        paramVarArgs.f(6, this.Uza);
      }
      if (this.tsf != null) {
        paramVarArgs.f(7, this.tsf);
      }
      paramVarArgs.aY(8, this.Uzb);
      AppMethodBeat.o(74673);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label648;
      }
    }
    label648:
    for (paramInt = g.a.a.b.b.a.g(1, this.appid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lnp != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.lnp);
      }
      i = i + g.a.a.b.b.a.bM(3, this.apptype) + g.a.a.a.c(4, 8, this.UyZ) + g.a.a.b.b.a.bM(5, this.TGY);
      paramInt = i;
      if (this.Uza != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Uza);
      }
      i = paramInt;
      if (this.tsf != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.tsf);
      }
      paramInt = g.a.a.b.b.a.bM(8, this.Uzb);
      AppMethodBeat.o(74673);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UyZ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(74673);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eyu localeyu = (eyu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74673);
          return -1;
        case 1: 
          localeyu.appid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(74673);
          return 0;
        case 2: 
          localeyu.lnp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(74673);
          return 0;
        case 3: 
          localeyu.apptype = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(74673);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            eyv localeyv = new eyv();
            if ((localObject != null) && (localObject.length > 0)) {
              localeyv.parseFrom((byte[])localObject);
            }
            localeyu.UyZ.add(localeyv);
            paramInt += 1;
          }
          AppMethodBeat.o(74673);
          return 0;
        case 5: 
          localeyu.TGY = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(74673);
          return 0;
        case 6: 
          localeyu.Uza = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(74673);
          return 0;
        case 7: 
          localeyu.tsf = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(74673);
          return 0;
        }
        localeyu.Uzb = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(74673);
        return 0;
      }
      AppMethodBeat.o(74673);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyu
 * JD-Core Version:    0.7.0.1
 */