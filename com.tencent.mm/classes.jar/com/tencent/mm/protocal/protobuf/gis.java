package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gis
  extends com.tencent.mm.bx.a
{
  public String IcC;
  public String Md5;
  public int acff;
  public int acfg;
  public giv acfh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110857);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: Md5");
        AppMethodBeat.o(110857);
        throw paramVarArgs;
      }
      if (this.IcC == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadUrl");
        AppMethodBeat.o(110857);
        throw paramVarArgs;
      }
      if (this.Md5 != null) {
        paramVarArgs.g(1, this.Md5);
      }
      if (this.IcC != null) {
        paramVarArgs.g(2, this.IcC);
      }
      paramVarArgs.bS(3, this.acff);
      paramVarArgs.bS(4, this.acfg);
      if (this.acfh != null)
      {
        paramVarArgs.qD(5, this.acfh.computeSize());
        this.acfh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110857);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label588;
      }
    }
    label588:
    for (paramInt = i.a.a.b.b.a.h(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IcC != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.IcC);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.acff) + i.a.a.b.b.a.cJ(4, this.acfg);
      paramInt = i;
      if (this.acfh != null) {
        paramInt = i + i.a.a.a.qC(5, this.acfh.computeSize());
      }
      AppMethodBeat.o(110857);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.Md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: Md5");
          AppMethodBeat.o(110857);
          throw paramVarArgs;
        }
        if (this.IcC == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadUrl");
          AppMethodBeat.o(110857);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110857);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gis localgis = (gis)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110857);
          return -1;
        case 1: 
          localgis.Md5 = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(110857);
          return 0;
        case 2: 
          localgis.IcC = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(110857);
          return 0;
        case 3: 
          localgis.acff = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(110857);
          return 0;
        case 4: 
          localgis.acfg = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(110857);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          giv localgiv = new giv();
          if ((localObject != null) && (localObject.length > 0)) {
            localgiv.parseFrom((byte[])localObject);
          }
          localgis.acfh = localgiv;
          paramInt += 1;
        }
        AppMethodBeat.o(110857);
        return 0;
      }
      AppMethodBeat.o(110857);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gis
 * JD-Core Version:    0.7.0.1
 */