package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class brg
  extends cvw
{
  public String Heu;
  public String Hev;
  public int Hew;
  public int Hex;
  public String Hey;
  public String Hez;
  public String dwb;
  public String packageName;
  public int phg;
  public int scene;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123602);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dwb != null) {
        paramVarArgs.d(2, this.dwb);
      }
      if (this.Heu != null) {
        paramVarArgs.d(3, this.Heu);
      }
      paramVarArgs.aS(4, this.scene);
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      if (this.Hev != null) {
        paramVarArgs.d(6, this.Hev);
      }
      paramVarArgs.aS(7, this.phg);
      paramVarArgs.aS(8, this.Hew);
      paramVarArgs.aS(9, this.Hex);
      if (this.Hey != null) {
        paramVarArgs.d(10, this.Hey);
      }
      if (this.packageName != null) {
        paramVarArgs.d(11, this.packageName);
      }
      if (this.Hez != null) {
        paramVarArgs.d(12, this.Hez);
      }
      AppMethodBeat.o(123602);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label918;
      }
    }
    label918:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dwb);
      }
      i = paramInt;
      if (this.Heu != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Heu);
      }
      i += f.a.a.b.b.a.bz(4, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.url);
      }
      i = paramInt;
      if (this.Hev != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Hev);
      }
      i = i + f.a.a.b.b.a.bz(7, this.phg) + f.a.a.b.b.a.bz(8, this.Hew) + f.a.a.b.b.a.bz(9, this.Hex);
      paramInt = i;
      if (this.Hey != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Hey);
      }
      i = paramInt;
      if (this.packageName != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.packageName);
      }
      paramInt = i;
      if (this.Hez != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Hez);
      }
      AppMethodBeat.o(123602);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123602);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        brg localbrg = (brg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123602);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrg.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123602);
          return 0;
        case 2: 
          localbrg.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 3: 
          localbrg.Heu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 4: 
          localbrg.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123602);
          return 0;
        case 5: 
          localbrg.url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 6: 
          localbrg.Hev = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 7: 
          localbrg.phg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123602);
          return 0;
        case 8: 
          localbrg.Hew = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123602);
          return 0;
        case 9: 
          localbrg.Hex = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123602);
          return 0;
        case 10: 
          localbrg.Hey = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123602);
          return 0;
        case 11: 
          localbrg.packageName = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123602);
          return 0;
        }
        localbrg.Hez = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(123602);
        return 0;
      }
      AppMethodBeat.o(123602);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brg
 * JD-Core Version:    0.7.0.1
 */