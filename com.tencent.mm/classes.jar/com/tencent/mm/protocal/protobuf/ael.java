package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ael
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> Gcp;
  public String Gcq;
  public String desc;
  public String detail;
  public String title;
  public String url;
  
  public ael()
  {
    AppMethodBeat.i(113994);
    this.Gcp = new LinkedList();
    AppMethodBeat.o(113994);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113995);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.desc != null) {
        paramVarArgs.d(3, this.desc);
      }
      paramVarArgs.e(4, 1, this.Gcp);
      if (this.detail != null) {
        paramVarArgs.d(5, this.detail);
      }
      if (this.Gcq != null) {
        paramVarArgs.d(6, this.Gcq);
      }
      AppMethodBeat.o(113995);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label514;
      }
    }
    label514:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.desc);
      }
      i += f.a.a.a.c(4, 1, this.Gcp);
      paramInt = i;
      if (this.detail != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.detail);
      }
      i = paramInt;
      if (this.Gcq != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Gcq);
      }
      AppMethodBeat.o(113995);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gcp.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(113995);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ael localael = (ael)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113995);
          return -1;
        case 1: 
          localael.title = locala.NPN.readString();
          AppMethodBeat.o(113995);
          return 0;
        case 2: 
          localael.url = locala.NPN.readString();
          AppMethodBeat.o(113995);
          return 0;
        case 3: 
          localael.desc = locala.NPN.readString();
          AppMethodBeat.o(113995);
          return 0;
        case 4: 
          localael.Gcp.add(locala.NPN.readString());
          AppMethodBeat.o(113995);
          return 0;
        case 5: 
          localael.detail = locala.NPN.readString();
          AppMethodBeat.o(113995);
          return 0;
        }
        localael.Gcq = locala.NPN.readString();
        AppMethodBeat.o(113995);
        return 0;
      }
      AppMethodBeat.o(113995);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ael
 * JD-Core Version:    0.7.0.1
 */