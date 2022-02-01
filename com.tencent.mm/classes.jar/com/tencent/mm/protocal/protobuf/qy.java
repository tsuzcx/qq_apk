package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class qy
  extends com.tencent.mm.bw.a
{
  public String Gfd;
  public String Gfe;
  public String Gff;
  public int Gfg;
  public String Gfh;
  public String wTF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117847);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gfd == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.wTF == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductName");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.Gfe == null)
      {
        paramVarArgs = new b("Not all required fields were included: SellerName");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.Gff == null)
      {
        paramVarArgs = new b("Not all required fields were included: SellerUserName");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.Gfd != null) {
        paramVarArgs.d(1, this.Gfd);
      }
      if (this.wTF != null) {
        paramVarArgs.d(2, this.wTF);
      }
      if (this.Gfe != null) {
        paramVarArgs.d(3, this.Gfe);
      }
      if (this.Gff != null) {
        paramVarArgs.d(4, this.Gff);
      }
      paramVarArgs.aS(5, this.Gfg);
      if (this.Gfh != null) {
        paramVarArgs.d(6, this.Gfh);
      }
      AppMethodBeat.o(117847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gfd == null) {
        break label694;
      }
    }
    label694:
    for (int i = f.a.a.b.b.a.e(1, this.Gfd) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wTF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.wTF);
      }
      i = paramInt;
      if (this.Gfe != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gfe);
      }
      paramInt = i;
      if (this.Gff != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gff);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Gfg);
      paramInt = i;
      if (this.Gfh != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gfh);
      }
      AppMethodBeat.o(117847);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Gfd == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductId");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        if (this.wTF == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductName");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        if (this.Gfe == null)
        {
          paramVarArgs = new b("Not all required fields were included: SellerName");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        if (this.Gff == null)
        {
          paramVarArgs = new b("Not all required fields were included: SellerUserName");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117847);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        qy localqy = (qy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117847);
          return -1;
        case 1: 
          localqy.Gfd = locala.OmT.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 2: 
          localqy.wTF = locala.OmT.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 3: 
          localqy.Gfe = locala.OmT.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 4: 
          localqy.Gff = locala.OmT.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 5: 
          localqy.Gfg = locala.OmT.zc();
          AppMethodBeat.o(117847);
          return 0;
        }
        localqy.Gfh = locala.OmT.readString();
        AppMethodBeat.o(117847);
        return 0;
      }
      AppMethodBeat.o(117847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qy
 * JD-Core Version:    0.7.0.1
 */