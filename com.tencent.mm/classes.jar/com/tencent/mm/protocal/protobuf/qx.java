package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class qx
  extends com.tencent.mm.bw.a
{
  public String GeY;
  public String GeZ;
  public int Gfa;
  public String Gfb;
  public int Gfc;
  public String Title;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117846);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(117846);
        throw paramVarArgs;
      }
      if (this.Url == null)
      {
        paramVarArgs = new b("Not all required fields were included: Url");
        AppMethodBeat.o(117846);
        throw paramVarArgs;
      }
      if (this.GeY == null)
      {
        paramVarArgs = new b("Not all required fields were included: Position");
        AppMethodBeat.o(117846);
        throw paramVarArgs;
      }
      if (this.GeZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: DetailInfo");
        AppMethodBeat.o(117846);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.Url != null) {
        paramVarArgs.d(2, this.Url);
      }
      if (this.GeY != null) {
        paramVarArgs.d(3, this.GeY);
      }
      if (this.GeZ != null) {
        paramVarArgs.d(4, this.GeZ);
      }
      paramVarArgs.aS(5, this.Gfa);
      if (this.Gfb != null) {
        paramVarArgs.d(6, this.Gfb);
      }
      paramVarArgs.aS(7, this.Gfc);
      AppMethodBeat.o(117846);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label738;
      }
    }
    label738:
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Url);
      }
      i = paramInt;
      if (this.GeY != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GeY);
      }
      paramInt = i;
      if (this.GeZ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GeZ);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Gfa);
      paramInt = i;
      if (this.Gfb != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gfb);
      }
      i = f.a.a.b.b.a.bz(7, this.Gfc);
      AppMethodBeat.o(117846);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(117846);
          throw paramVarArgs;
        }
        if (this.Url == null)
        {
          paramVarArgs = new b("Not all required fields were included: Url");
          AppMethodBeat.o(117846);
          throw paramVarArgs;
        }
        if (this.GeY == null)
        {
          paramVarArgs = new b("Not all required fields were included: Position");
          AppMethodBeat.o(117846);
          throw paramVarArgs;
        }
        if (this.GeZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: DetailInfo");
          AppMethodBeat.o(117846);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117846);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        qx localqx = (qx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117846);
          return -1;
        case 1: 
          localqx.Title = locala.OmT.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 2: 
          localqx.Url = locala.OmT.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 3: 
          localqx.GeY = locala.OmT.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 4: 
          localqx.GeZ = locala.OmT.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 5: 
          localqx.Gfa = locala.OmT.zc();
          AppMethodBeat.o(117846);
          return 0;
        case 6: 
          localqx.Gfb = locala.OmT.readString();
          AppMethodBeat.o(117846);
          return 0;
        }
        localqx.Gfc = locala.OmT.zc();
        AppMethodBeat.o(117846);
        return 0;
      }
      AppMethodBeat.o(117846);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qx
 * JD-Core Version:    0.7.0.1
 */