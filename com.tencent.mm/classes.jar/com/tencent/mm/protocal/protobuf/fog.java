package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class fog
  extends com.tencent.mm.bx.a
{
  public LinkedList<aem> Wol;
  public LinkedList<foh> aaUM;
  public String abOf;
  public String abOg;
  public String abOh;
  public String abOi;
  public long abOj;
  public fcl abOl;
  public boolean abOs;
  public String hAB;
  public int offset;
  public int scene;
  public String zIO;
  
  public fog()
  {
    AppMethodBeat.i(153010);
    this.aaUM = new LinkedList();
    this.Wol = new LinkedList();
    AppMethodBeat.o(153010);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258219);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "relevantVid", this.abOf, false);
      com.tencent.mm.bk.a.a(localJSONObject, "relevantExpand", this.abOg, false);
      com.tencent.mm.bk.a.a(localJSONObject, "relevantPreSearchId", this.abOh, false);
      com.tencent.mm.bk.a.a(localJSONObject, "relevantSharedOpenID", this.abOi, false);
      com.tencent.mm.bk.a.a(localJSONObject, "clickTag", this.abOl, false);
      com.tencent.mm.bk.a.a(localJSONObject, "recCategory", Long.valueOf(this.abOj), false);
      com.tencent.mm.bk.a.a(localJSONObject, "contextId", this.zIO, false);
      com.tencent.mm.bk.a.a(localJSONObject, "offset", Integer.valueOf(this.offset), false);
      com.tencent.mm.bk.a.a(localJSONObject, "isSinglePage", Boolean.valueOf(this.abOs), false);
      com.tencent.mm.bk.a.a(localJSONObject, "scene", Integer.valueOf(this.scene), false);
      com.tencent.mm.bk.a.a(localJSONObject, "keyword", this.hAB, false);
      com.tencent.mm.bk.a.a(localJSONObject, "cacheVideoList", this.aaUM, false);
      com.tencent.mm.bk.a.a(localJSONObject, "extReqParams", this.Wol, false);
      label168:
      AppMethodBeat.o(258219);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label168;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153011);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abOf != null) {
        paramVarArgs.g(1, this.abOf);
      }
      if (this.abOg != null) {
        paramVarArgs.g(2, this.abOg);
      }
      if (this.abOh != null) {
        paramVarArgs.g(3, this.abOh);
      }
      if (this.abOi != null) {
        paramVarArgs.g(4, this.abOi);
      }
      if (this.abOl != null)
      {
        paramVarArgs.qD(5, this.abOl.computeSize());
        this.abOl.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(6, this.abOj);
      if (this.zIO != null) {
        paramVarArgs.g(7, this.zIO);
      }
      paramVarArgs.bS(8, this.offset);
      paramVarArgs.di(9, this.abOs);
      paramVarArgs.bS(10, this.scene);
      if (this.hAB != null) {
        paramVarArgs.g(11, this.hAB);
      }
      paramVarArgs.e(12, 8, this.aaUM);
      paramVarArgs.e(13, 8, this.Wol);
      AppMethodBeat.o(153011);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abOf == null) {
        break label1068;
      }
    }
    label1068:
    for (int i = i.a.a.b.b.a.h(1, this.abOf) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abOg != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abOg);
      }
      i = paramInt;
      if (this.abOh != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abOh);
      }
      paramInt = i;
      if (this.abOi != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abOi);
      }
      i = paramInt;
      if (this.abOl != null) {
        i = paramInt + i.a.a.a.qC(5, this.abOl.computeSize());
      }
      i += i.a.a.b.b.a.q(6, this.abOj);
      paramInt = i;
      if (this.zIO != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.zIO);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.offset) + (i.a.a.b.b.a.ko(9) + 1) + i.a.a.b.b.a.cJ(10, this.scene);
      paramInt = i;
      if (this.hAB != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.hAB);
      }
      i = i.a.a.a.c(12, 8, this.aaUM);
      int j = i.a.a.a.c(13, 8, this.Wol);
      AppMethodBeat.o(153011);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaUM.clear();
        this.Wol.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153011);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fog localfog = (fog)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153011);
          return -1;
        case 1: 
          localfog.abOf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 2: 
          localfog.abOg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 3: 
          localfog.abOh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 4: 
          localfog.abOi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fcl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fcl)localObject2).parseFrom((byte[])localObject1);
            }
            localfog.abOl = ((fcl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153011);
          return 0;
        case 6: 
          localfog.abOj = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(153011);
          return 0;
        case 7: 
          localfog.zIO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 8: 
          localfog.offset = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(153011);
          return 0;
        case 9: 
          localfog.abOs = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(153011);
          return 0;
        case 10: 
          localfog.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(153011);
          return 0;
        case 11: 
          localfog.hAB = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new foh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((foh)localObject2).parseFrom((byte[])localObject1);
            }
            localfog.aaUM.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153011);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aem();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aem)localObject2).parseFrom((byte[])localObject1);
          }
          localfog.Wol.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(153011);
        return 0;
      }
      AppMethodBeat.o(153011);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fog
 * JD-Core Version:    0.7.0.1
 */