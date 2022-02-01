package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvl
  extends com.tencent.mm.bx.a
{
  public int FileSize;
  public com.tencent.mm.bx.b Gdx;
  public int HnK;
  public int HnL;
  public LinkedList<dek> HnM;
  public String HnN;
  public String MD5;
  public String Url;
  
  public cvl()
  {
    AppMethodBeat.i(152670);
    this.HnM = new LinkedList();
    AppMethodBeat.o(152670);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152671);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.MD5 == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: MD5");
        AppMethodBeat.o(152671);
        throw paramVarArgs;
      }
      if (this.Url == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Url");
        AppMethodBeat.o(152671);
        throw paramVarArgs;
      }
      if (this.HnN == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: OriginalMD5");
        AppMethodBeat.o(152671);
        throw paramVarArgs;
      }
      if (this.MD5 != null) {
        paramVarArgs.d(1, this.MD5);
      }
      paramVarArgs.aS(2, this.HnK);
      if (this.Url != null) {
        paramVarArgs.d(3, this.Url);
      }
      paramVarArgs.aS(4, this.HnL);
      paramVarArgs.e(5, 8, this.HnM);
      if (this.Gdx != null) {
        paramVarArgs.c(6, this.Gdx);
      }
      if (this.HnN != null) {
        paramVarArgs.d(7, this.HnN);
      }
      paramVarArgs.aS(8, this.FileSize);
      AppMethodBeat.o(152671);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label818;
      }
    }
    label818:
    for (paramInt = f.a.a.b.b.a.e(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HnK);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Url);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.HnL) + f.a.a.a.c(5, 8, this.HnM);
      paramInt = i;
      if (this.Gdx != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.Gdx);
      }
      i = paramInt;
      if (this.HnN != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HnN);
      }
      paramInt = f.a.a.b.b.a.bz(8, this.FileSize);
      AppMethodBeat.o(152671);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HnM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.MD5 == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: MD5");
          AppMethodBeat.o(152671);
          throw paramVarArgs;
        }
        if (this.Url == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Url");
          AppMethodBeat.o(152671);
          throw paramVarArgs;
        }
        if (this.HnN == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: OriginalMD5");
          AppMethodBeat.o(152671);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152671);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cvl localcvl = (cvl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152671);
          return -1;
        case 1: 
          localcvl.MD5 = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152671);
          return 0;
        case 2: 
          localcvl.HnK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152671);
          return 0;
        case 3: 
          localcvl.Url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152671);
          return 0;
        case 4: 
          localcvl.HnL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152671);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dek();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dek)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvl.HnM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152671);
          return 0;
        case 6: 
          localcvl.Gdx = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(152671);
          return 0;
        case 7: 
          localcvl.HnN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152671);
          return 0;
        }
        localcvl.FileSize = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152671);
        return 0;
      }
      AppMethodBeat.o(152671);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvl
 * JD-Core Version:    0.7.0.1
 */