package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ckz
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b DcU;
  public String EgA;
  public int Egx;
  public int Egy;
  public LinkedList<ctm> Egz;
  public int FileSize;
  public String MD5;
  public String Url;
  
  public ckz()
  {
    AppMethodBeat.i(152670);
    this.Egz = new LinkedList();
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
      if (this.EgA == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: OriginalMD5");
        AppMethodBeat.o(152671);
        throw paramVarArgs;
      }
      if (this.MD5 != null) {
        paramVarArgs.d(1, this.MD5);
      }
      paramVarArgs.aR(2, this.Egx);
      if (this.Url != null) {
        paramVarArgs.d(3, this.Url);
      }
      paramVarArgs.aR(4, this.Egy);
      paramVarArgs.e(5, 8, this.Egz);
      if (this.DcU != null) {
        paramVarArgs.c(6, this.DcU);
      }
      if (this.EgA != null) {
        paramVarArgs.d(7, this.EgA);
      }
      paramVarArgs.aR(8, this.FileSize);
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
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Egx);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Url);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.Egy) + f.a.a.a.c(5, 8, this.Egz);
      paramInt = i;
      if (this.DcU != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.DcU);
      }
      i = paramInt;
      if (this.EgA != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EgA);
      }
      paramInt = f.a.a.b.b.a.bA(8, this.FileSize);
      AppMethodBeat.o(152671);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Egz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
        if (this.EgA == null)
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
        ckz localckz = (ckz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152671);
          return -1;
        case 1: 
          localckz.MD5 = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152671);
          return 0;
        case 2: 
          localckz.Egx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152671);
          return 0;
        case 3: 
          localckz.Url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152671);
          return 0;
        case 4: 
          localckz.Egy = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152671);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ctm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localckz.Egz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152671);
          return 0;
        case 6: 
          localckz.DcU = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(152671);
          return 0;
        case 7: 
          localckz.EgA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152671);
          return 0;
        }
        localckz.FileSize = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152671);
        return 0;
      }
      AppMethodBeat.o(152671);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckz
 * JD-Core Version:    0.7.0.1
 */