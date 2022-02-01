package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cfp
  extends com.tencent.mm.bw.a
{
  public String FNU;
  public String Hsg;
  public String Hsh;
  public String Hss;
  public String Hsu;
  public String Hsv;
  public String Hsw;
  public String Hsx;
  public cfq Hsy;
  public String app_id;
  public int doj;
  public int eQV;
  public String iKt;
  public String iWF;
  public String nickname;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152638);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iKt != null) {
        paramVarArgs.d(1, this.iKt);
      }
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      paramVarArgs.aS(3, this.type);
      if (this.iWF != null) {
        paramVarArgs.d(4, this.iWF);
      }
      if (this.Hsg != null) {
        paramVarArgs.d(5, this.Hsg);
      }
      if (this.Hsh != null) {
        paramVarArgs.d(6, this.Hsh);
      }
      paramVarArgs.aS(7, this.doj);
      if (this.Hsu != null) {
        paramVarArgs.d(8, this.Hsu);
      }
      if (this.Hsv != null) {
        paramVarArgs.d(9, this.Hsv);
      }
      if (this.Hsw != null) {
        paramVarArgs.d(10, this.Hsw);
      }
      if (this.Hsx != null) {
        paramVarArgs.d(11, this.Hsx);
      }
      if (this.Hsy != null)
      {
        paramVarArgs.lJ(12, this.Hsy.computeSize());
        this.Hsy.writeFields(paramVarArgs);
      }
      if (this.FNU != null) {
        paramVarArgs.d(13, this.FNU);
      }
      if (this.app_id != null) {
        paramVarArgs.d(14, this.app_id);
      }
      paramVarArgs.aS(15, this.eQV);
      if (this.Hss != null) {
        paramVarArgs.d(16, this.Hss);
      }
      AppMethodBeat.o(152638);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iKt == null) {
        break label1186;
      }
    }
    label1186:
    for (paramInt = f.a.a.b.b.a.e(1, this.iKt) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nickname);
      }
      i += f.a.a.b.b.a.bz(3, this.type);
      paramInt = i;
      if (this.iWF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.iWF);
      }
      i = paramInt;
      if (this.Hsg != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Hsg);
      }
      paramInt = i;
      if (this.Hsh != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hsh);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.doj);
      paramInt = i;
      if (this.Hsu != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Hsu);
      }
      i = paramInt;
      if (this.Hsv != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Hsv);
      }
      paramInt = i;
      if (this.Hsw != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Hsw);
      }
      i = paramInt;
      if (this.Hsx != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Hsx);
      }
      paramInt = i;
      if (this.Hsy != null) {
        paramInt = i + f.a.a.a.lI(12, this.Hsy.computeSize());
      }
      i = paramInt;
      if (this.FNU != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.FNU);
      }
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.app_id);
      }
      i = paramInt + f.a.a.b.b.a.bz(15, this.eQV);
      paramInt = i;
      if (this.Hss != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.Hss);
      }
      AppMethodBeat.o(152638);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152638);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cfp localcfp = (cfp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152638);
          return -1;
        case 1: 
          localcfp.iKt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 2: 
          localcfp.nickname = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 3: 
          localcfp.type = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152638);
          return 0;
        case 4: 
          localcfp.iWF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 5: 
          localcfp.Hsg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 6: 
          localcfp.Hsh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 7: 
          localcfp.doj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152638);
          return 0;
        case 8: 
          localcfp.Hsu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 9: 
          localcfp.Hsv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 10: 
          localcfp.Hsw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 11: 
          localcfp.Hsx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cfq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcfp.Hsy = ((cfq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152638);
          return 0;
        case 13: 
          localcfp.FNU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 14: 
          localcfp.app_id = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152638);
          return 0;
        case 15: 
          localcfp.eQV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152638);
          return 0;
        }
        localcfp.Hss = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152638);
        return 0;
      }
      AppMethodBeat.o(152638);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfp
 * JD-Core Version:    0.7.0.1
 */