package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class db
  extends com.tencent.mm.cd.a
{
  public int COi;
  public int CreateTime;
  public int HlE;
  public long HlH;
  public eaf RID;
  public eaf RIE;
  public eaf RIF;
  public int RIG;
  public eae RIH;
  public String RII;
  public String RIJ;
  public int RIK;
  public int rVU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133143);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RID == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.RIE == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.RIF == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.RIH == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.HlE);
      if (this.RID != null)
      {
        paramVarArgs.oE(2, this.RID.computeSize());
        this.RID.writeFields(paramVarArgs);
      }
      if (this.RIE != null)
      {
        paramVarArgs.oE(3, this.RIE.computeSize());
        this.RIE.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.COi);
      if (this.RIF != null)
      {
        paramVarArgs.oE(5, this.RIF.computeSize());
        this.RIF.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.rVU);
      paramVarArgs.aY(7, this.RIG);
      if (this.RIH != null)
      {
        paramVarArgs.oE(8, this.RIH.computeSize());
        this.RIH.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(9, this.CreateTime);
      if (this.RII != null) {
        paramVarArgs.f(10, this.RII);
      }
      if (this.RIJ != null) {
        paramVarArgs.f(11, this.RIJ);
      }
      paramVarArgs.bm(12, this.HlH);
      paramVarArgs.aY(13, this.RIK);
      AppMethodBeat.o(133143);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.HlE) + 0;
      paramInt = i;
      if (this.RID != null) {
        paramInt = i + g.a.a.a.oD(2, this.RID.computeSize());
      }
      i = paramInt;
      if (this.RIE != null) {
        i = paramInt + g.a.a.a.oD(3, this.RIE.computeSize());
      }
      i += g.a.a.b.b.a.bM(4, this.COi);
      paramInt = i;
      if (this.RIF != null) {
        paramInt = i + g.a.a.a.oD(5, this.RIF.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.rVU) + g.a.a.b.b.a.bM(7, this.RIG);
      paramInt = i;
      if (this.RIH != null) {
        paramInt = i + g.a.a.a.oD(8, this.RIH.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.CreateTime);
      paramInt = i;
      if (this.RII != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.RII);
      }
      i = paramInt;
      if (this.RIJ != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.RIJ);
      }
      paramInt = g.a.a.b.b.a.p(12, this.HlH);
      int j = g.a.a.b.b.a.bM(13, this.RIK);
      AppMethodBeat.o(133143);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.RID == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.RIE == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.RIF == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.RIH == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133143);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      db localdb = (db)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133143);
        return -1;
      case 1: 
        localdb.HlE = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133143);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eaf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eaf)localObject2).de((byte[])localObject1);
          }
          localdb.RID = ((eaf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eaf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eaf)localObject2).de((byte[])localObject1);
          }
          localdb.RIE = ((eaf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 4: 
        localdb.COi = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133143);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eaf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eaf)localObject2).de((byte[])localObject1);
          }
          localdb.RIF = ((eaf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 6: 
        localdb.rVU = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133143);
        return 0;
      case 7: 
        localdb.RIG = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133143);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localdb.RIH = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 9: 
        localdb.CreateTime = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133143);
        return 0;
      case 10: 
        localdb.RII = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(133143);
        return 0;
      case 11: 
        localdb.RIJ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(133143);
        return 0;
      case 12: 
        localdb.HlH = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(133143);
        return 0;
      }
      localdb.RIK = ((g.a.a.a.a)localObject1).abFh.AK();
      AppMethodBeat.o(133143);
      return 0;
    }
    AppMethodBeat.o(133143);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.db
 * JD-Core Version:    0.7.0.1
 */