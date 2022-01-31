package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvg
  extends com.tencent.mm.bv.a
{
  public int FileSize;
  public String Url;
  public com.tencent.mm.bv.b wPX;
  public String wQr;
  public int xIX;
  public int xIY;
  public LinkedList<ccr> xIZ;
  public String xJa;
  
  public bvg()
  {
    AppMethodBeat.i(80164);
    this.xIZ = new LinkedList();
    AppMethodBeat.o(80164);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80165);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wQr == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: MD5");
        AppMethodBeat.o(80165);
        throw paramVarArgs;
      }
      if (this.Url == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Url");
        AppMethodBeat.o(80165);
        throw paramVarArgs;
      }
      if (this.xJa == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: OriginalMD5");
        AppMethodBeat.o(80165);
        throw paramVarArgs;
      }
      if (this.wQr != null) {
        paramVarArgs.e(1, this.wQr);
      }
      paramVarArgs.aO(2, this.xIX);
      if (this.Url != null) {
        paramVarArgs.e(3, this.Url);
      }
      paramVarArgs.aO(4, this.xIY);
      paramVarArgs.e(5, 8, this.xIZ);
      if (this.wPX != null) {
        paramVarArgs.c(6, this.wPX);
      }
      if (this.xJa != null) {
        paramVarArgs.e(7, this.xJa);
      }
      paramVarArgs.aO(8, this.FileSize);
      AppMethodBeat.o(80165);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wQr == null) {
        break label818;
      }
    }
    label818:
    for (paramInt = e.a.a.b.b.a.f(1, this.wQr) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xIX);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.Url);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.xIY) + e.a.a.a.c(5, 8, this.xIZ);
      paramInt = i;
      if (this.wPX != null) {
        paramInt = i + e.a.a.b.b.a.b(6, this.wPX);
      }
      i = paramInt;
      if (this.xJa != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.xJa);
      }
      paramInt = e.a.a.b.b.a.bl(8, this.FileSize);
      AppMethodBeat.o(80165);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xIZ.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wQr == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: MD5");
          AppMethodBeat.o(80165);
          throw paramVarArgs;
        }
        if (this.Url == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: Url");
          AppMethodBeat.o(80165);
          throw paramVarArgs;
        }
        if (this.xJa == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: OriginalMD5");
          AppMethodBeat.o(80165);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80165);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bvg localbvg = (bvg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80165);
          return -1;
        case 1: 
          localbvg.wQr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80165);
          return 0;
        case 2: 
          localbvg.xIX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80165);
          return 0;
        case 3: 
          localbvg.Url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80165);
          return 0;
        case 4: 
          localbvg.xIY = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80165);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccr();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ccr)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbvg.xIZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80165);
          return 0;
        case 6: 
          localbvg.wPX = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(80165);
          return 0;
        case 7: 
          localbvg.xJa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80165);
          return 0;
        }
        localbvg.FileSize = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(80165);
        return 0;
      }
      AppMethodBeat.o(80165);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvg
 * JD-Core Version:    0.7.0.1
 */