package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cxa
  extends com.tencent.mm.cd.a
{
  public eaf SqW;
  public eaf SqX;
  public int Sqi;
  public eaf SrM;
  public eaf TFA;
  public eaf TFB;
  public int TFy;
  public eaf TFz;
  public eaf TtX;
  public int TxF;
  public String TxG;
  public String mVA;
  public String mVB;
  public int mVC;
  public String mVH;
  public int mVy;
  public String mVz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101823);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SrM == null)
      {
        paramVarArgs = new b("Not all required fields were included: MemberName");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.TtX == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.SqW == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.SqX == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.TFz == null)
      {
        paramVarArgs = new b("Not all required fields were included: Remark");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.TFA == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.TFB == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.SrM != null)
      {
        paramVarArgs.oE(1, this.SrM.computeSize());
        this.SrM.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TFy);
      if (this.TtX != null)
      {
        paramVarArgs.oE(3, this.TtX.computeSize());
        this.TtX.writeFields(paramVarArgs);
      }
      if (this.SqW != null)
      {
        paramVarArgs.oE(4, this.SqW.computeSize());
        this.SqW.writeFields(paramVarArgs);
      }
      if (this.SqX != null)
      {
        paramVarArgs.oE(5, this.SqX.computeSize());
        this.SqX.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.mVy);
      if (this.TFz != null)
      {
        paramVarArgs.oE(9, this.TFz.computeSize());
        this.TFz.writeFields(paramVarArgs);
      }
      if (this.TFA != null)
      {
        paramVarArgs.oE(10, this.TFA.computeSize());
        this.TFA.writeFields(paramVarArgs);
      }
      if (this.TFB != null)
      {
        paramVarArgs.oE(11, this.TFB.computeSize());
        this.TFB.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(12, this.Sqi);
      if (this.mVz != null) {
        paramVarArgs.f(13, this.mVz);
      }
      if (this.mVA != null) {
        paramVarArgs.f(14, this.mVA);
      }
      if (this.mVB != null) {
        paramVarArgs.f(15, this.mVB);
      }
      paramVarArgs.aY(16, this.mVC);
      paramVarArgs.aY(17, this.TxF);
      if (this.TxG != null) {
        paramVarArgs.f(18, this.TxG);
      }
      if (this.mVH != null) {
        paramVarArgs.f(19, this.mVH);
      }
      AppMethodBeat.o(101823);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SrM == null) {
        break label1968;
      }
    }
    label1968:
    for (paramInt = g.a.a.a.oD(1, this.SrM.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TFy);
      paramInt = i;
      if (this.TtX != null) {
        paramInt = i + g.a.a.a.oD(3, this.TtX.computeSize());
      }
      i = paramInt;
      if (this.SqW != null) {
        i = paramInt + g.a.a.a.oD(4, this.SqW.computeSize());
      }
      paramInt = i;
      if (this.SqX != null) {
        paramInt = i + g.a.a.a.oD(5, this.SqX.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.mVy);
      paramInt = i;
      if (this.TFz != null) {
        paramInt = i + g.a.a.a.oD(9, this.TFz.computeSize());
      }
      i = paramInt;
      if (this.TFA != null) {
        i = paramInt + g.a.a.a.oD(10, this.TFA.computeSize());
      }
      paramInt = i;
      if (this.TFB != null) {
        paramInt = i + g.a.a.a.oD(11, this.TFB.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.Sqi);
      paramInt = i;
      if (this.mVz != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.mVz);
      }
      i = paramInt;
      if (this.mVA != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.mVA);
      }
      paramInt = i;
      if (this.mVB != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.mVB);
      }
      i = paramInt + g.a.a.b.b.a.bM(16, this.mVC) + g.a.a.b.b.a.bM(17, this.TxF);
      paramInt = i;
      if (this.TxG != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.TxG);
      }
      i = paramInt;
      if (this.mVH != null) {
        i = paramInt + g.a.a.b.b.a.g(19, this.mVH);
      }
      AppMethodBeat.o(101823);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.SrM == null)
        {
          paramVarArgs = new b("Not all required fields were included: MemberName");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.TtX == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.SqW == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.SqX == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.TFz == null)
        {
          paramVarArgs = new b("Not all required fields were included: Remark");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.TFA == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.TFB == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101823);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cxa localcxa = (cxa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        eaf localeaf;
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(101823);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localeaf = new eaf();
            if ((localObject != null) && (localObject.length > 0)) {
              localeaf.de((byte[])localObject);
            }
            localcxa.SrM = localeaf;
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 2: 
          localcxa.TFy = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(101823);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localeaf = new eaf();
            if ((localObject != null) && (localObject.length > 0)) {
              localeaf.de((byte[])localObject);
            }
            localcxa.TtX = localeaf;
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localeaf = new eaf();
            if ((localObject != null) && (localObject.length > 0)) {
              localeaf.de((byte[])localObject);
            }
            localcxa.SqW = localeaf;
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localeaf = new eaf();
            if ((localObject != null) && (localObject.length > 0)) {
              localeaf.de((byte[])localObject);
            }
            localcxa.SqX = localeaf;
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 6: 
          localcxa.mVy = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(101823);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localeaf = new eaf();
            if ((localObject != null) && (localObject.length > 0)) {
              localeaf.de((byte[])localObject);
            }
            localcxa.TFz = localeaf;
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localeaf = new eaf();
            if ((localObject != null) && (localObject.length > 0)) {
              localeaf.de((byte[])localObject);
            }
            localcxa.TFA = localeaf;
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localeaf = new eaf();
            if ((localObject != null) && (localObject.length > 0)) {
              localeaf.de((byte[])localObject);
            }
            localcxa.TFB = localeaf;
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 12: 
          localcxa.Sqi = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(101823);
          return 0;
        case 13: 
          localcxa.mVz = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(101823);
          return 0;
        case 14: 
          localcxa.mVA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(101823);
          return 0;
        case 15: 
          localcxa.mVB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(101823);
          return 0;
        case 16: 
          localcxa.mVC = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(101823);
          return 0;
        case 17: 
          localcxa.TxF = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(101823);
          return 0;
        case 18: 
          localcxa.TxG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(101823);
          return 0;
        }
        localcxa.mVH = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(101823);
        return 0;
      }
      AppMethodBeat.o(101823);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxa
 * JD-Core Version:    0.7.0.1
 */