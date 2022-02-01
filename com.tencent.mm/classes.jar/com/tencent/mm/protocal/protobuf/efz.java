package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class efz
  extends com.tencent.mm.bw.a
{
  public LinkedList<efx> IjD;
  public boolean IjE;
  public boolean IjF;
  public boolean IjG;
  public String dyc;
  public long iwX;
  public int nLC;
  public String oqj;
  public String osm;
  public String url;
  
  public efz()
  {
    AppMethodBeat.i(208569);
    this.IjD = new LinkedList();
    AppMethodBeat.o(208569);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208570);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(208570);
        throw paramVarArgs;
      }
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      paramVarArgs.aZ(2, this.iwX);
      paramVarArgs.bC(3, this.IjE);
      paramVarArgs.bC(4, this.IjF);
      if (this.oqj != null) {
        paramVarArgs.d(5, this.oqj);
      }
      if (this.osm != null) {
        paramVarArgs.d(6, this.osm);
      }
      if (this.dyc != null) {
        paramVarArgs.d(7, this.dyc);
      }
      paramVarArgs.bC(8, this.IjG);
      paramVarArgs.e(9, 8, this.IjD);
      paramVarArgs.aS(10, this.nLC);
      AppMethodBeat.o(208570);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = f.a.a.b.b.a.e(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.iwX) + f.a.a.b.b.a.amF(3) + f.a.a.b.b.a.amF(4);
      paramInt = i;
      if (this.oqj != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.oqj);
      }
      i = paramInt;
      if (this.osm != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.osm);
      }
      paramInt = i;
      if (this.dyc != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.dyc);
      }
      i = f.a.a.b.b.a.amF(8);
      int j = f.a.a.a.c(9, 8, this.IjD);
      int k = f.a.a.b.b.a.bz(10, this.nLC);
      AppMethodBeat.o(208570);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IjD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.url == null)
        {
          paramVarArgs = new b("Not all required fields were included: url");
          AppMethodBeat.o(208570);
          throw paramVarArgs;
        }
        AppMethodBeat.o(208570);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        efz localefz = (efz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(208570);
          return -1;
        case 1: 
          localefz.url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(208570);
          return 0;
        case 2: 
          localefz.iwX = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(208570);
          return 0;
        case 3: 
          localefz.IjE = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(208570);
          return 0;
        case 4: 
          localefz.IjF = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(208570);
          return 0;
        case 5: 
          localefz.oqj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(208570);
          return 0;
        case 6: 
          localefz.osm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(208570);
          return 0;
        case 7: 
          localefz.dyc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(208570);
          return 0;
        case 8: 
          localefz.IjG = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(208570);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new efx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((efx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localefz.IjD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(208570);
          return 0;
        }
        localefz.nLC = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(208570);
        return 0;
      }
      AppMethodBeat.o(208570);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efz
 * JD-Core Version:    0.7.0.1
 */