package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;
import org.json.JSONObject;

public final class ewb
  extends com.tencent.mm.bx.a
{
  public String ZhO;
  public String ZhP;
  public etl ZqL;
  public etl aaIz;
  public int aaMm;
  public String aaMn;
  public String aaMo;
  public String aaMp;
  public int aaMq;
  public ahm abyE;
  public int pSf;
  public String pSg;
  public String pSh;
  public String pSi;
  public int pSj;
  public String pSk;
  public String pSo;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259989);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "UserName", this.ZqL, false);
      com.tencent.mm.bk.a.a(localJSONObject, "NickName", this.aaIz, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Sex", Integer.valueOf(this.pSf), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Province", this.pSg, false);
      com.tencent.mm.bk.a.a(localJSONObject, "City", this.pSh, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Signature", this.pSi, false);
      com.tencent.mm.bk.a.a(localJSONObject, "PersonalCard", Integer.valueOf(this.pSj), false);
      com.tencent.mm.bk.a.a(localJSONObject, "VerifyFlag", Integer.valueOf(this.aaMm), false);
      com.tencent.mm.bk.a.a(localJSONObject, "VerifyInfo", this.aaMn, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Weibo", this.aaMo, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Alias", this.pSk, false);
      com.tencent.mm.bk.a.a(localJSONObject, "WeiboNickname", this.aaMp, false);
      com.tencent.mm.bk.a.a(localJSONObject, "WeiboFlag", Integer.valueOf(this.aaMq), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Country", this.pSo, false);
      com.tencent.mm.bk.a.a(localJSONObject, "CustomizedInfo", this.abyE, false);
      com.tencent.mm.bk.a.a(localJSONObject, "BigHeadImgUrl", this.ZhO, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SmallHeadImgUrl", this.ZhP, false);
      label212:
      AppMethodBeat.o(259989);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label212;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117918);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZqL == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(117918);
        throw paramVarArgs;
      }
      if (this.aaIz == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(117918);
        throw paramVarArgs;
      }
      if (this.ZqL != null)
      {
        paramVarArgs.qD(1, this.ZqL.computeSize());
        this.ZqL.writeFields(paramVarArgs);
      }
      if (this.aaIz != null)
      {
        paramVarArgs.qD(2, this.aaIz.computeSize());
        this.aaIz.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.pSf);
      if (this.pSg != null) {
        paramVarArgs.g(4, this.pSg);
      }
      if (this.pSh != null) {
        paramVarArgs.g(5, this.pSh);
      }
      if (this.pSi != null) {
        paramVarArgs.g(6, this.pSi);
      }
      paramVarArgs.bS(7, this.pSj);
      paramVarArgs.bS(8, this.aaMm);
      if (this.aaMn != null) {
        paramVarArgs.g(9, this.aaMn);
      }
      if (this.aaMo != null) {
        paramVarArgs.g(10, this.aaMo);
      }
      if (this.pSk != null) {
        paramVarArgs.g(11, this.pSk);
      }
      if (this.aaMp != null) {
        paramVarArgs.g(12, this.aaMp);
      }
      paramVarArgs.bS(13, this.aaMq);
      if (this.pSo != null) {
        paramVarArgs.g(14, this.pSo);
      }
      if (this.abyE != null)
      {
        paramVarArgs.qD(15, this.abyE.computeSize());
        this.abyE.writeFields(paramVarArgs);
      }
      if (this.ZhO != null) {
        paramVarArgs.g(16, this.ZhO);
      }
      if (this.ZhP != null) {
        paramVarArgs.g(17, this.ZhP);
      }
      AppMethodBeat.o(117918);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZqL == null) {
        break label1444;
      }
    }
    label1444:
    for (paramInt = i.a.a.a.qC(1, this.ZqL.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaIz != null) {
        i = paramInt + i.a.a.a.qC(2, this.aaIz.computeSize());
      }
      i += i.a.a.b.b.a.cJ(3, this.pSf);
      paramInt = i;
      if (this.pSg != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.pSg);
      }
      i = paramInt;
      if (this.pSh != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.pSh);
      }
      paramInt = i;
      if (this.pSi != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.pSi);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.pSj) + i.a.a.b.b.a.cJ(8, this.aaMm);
      paramInt = i;
      if (this.aaMn != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.aaMn);
      }
      i = paramInt;
      if (this.aaMo != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.aaMo);
      }
      paramInt = i;
      if (this.pSk != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.pSk);
      }
      i = paramInt;
      if (this.aaMp != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.aaMp);
      }
      i += i.a.a.b.b.a.cJ(13, this.aaMq);
      paramInt = i;
      if (this.pSo != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.pSo);
      }
      i = paramInt;
      if (this.abyE != null) {
        i = paramInt + i.a.a.a.qC(15, this.abyE.computeSize());
      }
      paramInt = i;
      if (this.ZhO != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.ZhO);
      }
      i = paramInt;
      if (this.ZhP != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.ZhP);
      }
      AppMethodBeat.o(117918);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ZqL == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(117918);
          throw paramVarArgs;
        }
        if (this.aaIz == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(117918);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117918);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ewb localewb = (ewb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117918);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localewb.ZqL = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117918);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localewb.aaIz = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117918);
          return 0;
        case 3: 
          localewb.pSf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117918);
          return 0;
        case 4: 
          localewb.pSg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 5: 
          localewb.pSh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 6: 
          localewb.pSi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 7: 
          localewb.pSj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117918);
          return 0;
        case 8: 
          localewb.aaMm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117918);
          return 0;
        case 9: 
          localewb.aaMn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 10: 
          localewb.aaMo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 11: 
          localewb.pSk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 12: 
          localewb.aaMp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 13: 
          localewb.aaMq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117918);
          return 0;
        case 14: 
          localewb.pSo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ahm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ahm)localObject2).parseFrom((byte[])localObject1);
            }
            localewb.abyE = ((ahm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117918);
          return 0;
        case 16: 
          localewb.ZhO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117918);
          return 0;
        }
        localewb.ZhP = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(117918);
        return 0;
      }
      AppMethodBeat.o(117918);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewb
 * JD-Core Version:    0.7.0.1
 */