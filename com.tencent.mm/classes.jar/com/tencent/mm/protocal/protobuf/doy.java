package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class doy
  extends com.tencent.mm.bw.a
{
  public int FileSize;
  public String MD5;
  public int MSu;
  public int MSv;
  public LinkedList<dyk> MSw;
  public com.tencent.mm.bw.b MSx;
  public String MSy;
  public String Url;
  
  public doy()
  {
    AppMethodBeat.i(152670);
    this.MSw = new LinkedList();
    AppMethodBeat.o(152670);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152671);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MD5 == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: MD5");
        AppMethodBeat.o(152671);
        throw paramVarArgs;
      }
      if (this.Url == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Url");
        AppMethodBeat.o(152671);
        throw paramVarArgs;
      }
      if (this.MSy == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: OriginalMD5");
        AppMethodBeat.o(152671);
        throw paramVarArgs;
      }
      if (this.MD5 != null) {
        paramVarArgs.e(1, this.MD5);
      }
      paramVarArgs.aM(2, this.MSu);
      if (this.Url != null) {
        paramVarArgs.e(3, this.Url);
      }
      paramVarArgs.aM(4, this.MSv);
      paramVarArgs.e(5, 8, this.MSw);
      if (this.MSx != null) {
        paramVarArgs.c(6, this.MSx);
      }
      if (this.MSy != null) {
        paramVarArgs.e(7, this.MSy);
      }
      paramVarArgs.aM(8, this.FileSize);
      AppMethodBeat.o(152671);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label818;
      }
    }
    label818:
    for (paramInt = g.a.a.b.b.a.f(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MSu);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Url);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.MSv) + g.a.a.a.c(5, 8, this.MSw);
      paramInt = i;
      if (this.MSx != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.MSx);
      }
      i = paramInt;
      if (this.MSy != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.MSy);
      }
      paramInt = g.a.a.b.b.a.bu(8, this.FileSize);
      AppMethodBeat.o(152671);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MSw.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MD5 == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: MD5");
          AppMethodBeat.o(152671);
          throw paramVarArgs;
        }
        if (this.Url == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Url");
          AppMethodBeat.o(152671);
          throw paramVarArgs;
        }
        if (this.MSy == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: OriginalMD5");
          AppMethodBeat.o(152671);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152671);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        doy localdoy = (doy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152671);
          return -1;
        case 1: 
          localdoy.MD5 = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152671);
          return 0;
        case 2: 
          localdoy.MSu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152671);
          return 0;
        case 3: 
          localdoy.Url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152671);
          return 0;
        case 4: 
          localdoy.MSv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152671);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dyk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdoy.MSw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152671);
          return 0;
        case 6: 
          localdoy.MSx = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(152671);
          return 0;
        case 7: 
          localdoy.MSy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152671);
          return 0;
        }
        localdoy.FileSize = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152671);
        return 0;
      }
      AppMethodBeat.o(152671);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doy
 * JD-Core Version:    0.7.0.1
 */