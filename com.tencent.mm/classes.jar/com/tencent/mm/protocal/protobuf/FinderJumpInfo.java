package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderJumpInfo
  extends com.tencent.mm.bx.a
{
  public int banner_type;
  public int business_type;
  public int dislike;
  public int expired_ts;
  public String ext_info;
  public Html5Info html5_info;
  public String icon_url;
  public String icon_url_bg;
  public String icon_url_dark;
  public String jump_id;
  public int jumpinfo_type;
  public MiniAppInfo mini_app_info;
  public NativeInfo native_info;
  public int position;
  public String recommend_reason;
  public FinderJumpInfoRedDot red_dot;
  public String report_info;
  public SchemaInfo schema_info;
  public int source;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258331);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.jumpinfo_type);
      paramVarArgs.bS(2, this.business_type);
      if (this.icon_url != null) {
        paramVarArgs.g(3, this.icon_url);
      }
      if (this.wording != null) {
        paramVarArgs.g(4, this.wording);
      }
      if (this.recommend_reason != null) {
        paramVarArgs.g(5, this.recommend_reason);
      }
      if (this.ext_info != null) {
        paramVarArgs.g(6, this.ext_info);
      }
      if (this.report_info != null) {
        paramVarArgs.g(7, this.report_info);
      }
      if (this.mini_app_info != null)
      {
        paramVarArgs.qD(8, this.mini_app_info.computeSize());
        this.mini_app_info.writeFields(paramVarArgs);
      }
      if (this.html5_info != null)
      {
        paramVarArgs.qD(9, this.html5_info.computeSize());
        this.html5_info.writeFields(paramVarArgs);
      }
      if (this.native_info != null)
      {
        paramVarArgs.qD(10, this.native_info.computeSize());
        this.native_info.writeFields(paramVarArgs);
      }
      if (this.schema_info != null)
      {
        paramVarArgs.qD(11, this.schema_info.computeSize());
        this.schema_info.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(12, this.source);
      paramVarArgs.bS(13, this.expired_ts);
      paramVarArgs.bS(14, this.dislike);
      if (this.icon_url_dark != null) {
        paramVarArgs.g(15, this.icon_url_dark);
      }
      if (this.icon_url_bg != null) {
        paramVarArgs.g(16, this.icon_url_bg);
      }
      if (this.red_dot != null)
      {
        paramVarArgs.qD(18, this.red_dot.computeSize());
        this.red_dot.writeFields(paramVarArgs);
      }
      if (this.jump_id != null) {
        paramVarArgs.g(19, this.jump_id);
      }
      paramVarArgs.bS(20, this.banner_type);
      paramVarArgs.bS(21, this.position);
      AppMethodBeat.o(258331);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.jumpinfo_type) + 0 + i.a.a.b.b.a.cJ(2, this.business_type);
      paramInt = i;
      if (this.icon_url != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.icon_url);
      }
      i = paramInt;
      if (this.wording != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.wording);
      }
      paramInt = i;
      if (this.recommend_reason != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.recommend_reason);
      }
      i = paramInt;
      if (this.ext_info != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.ext_info);
      }
      paramInt = i;
      if (this.report_info != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.report_info);
      }
      i = paramInt;
      if (this.mini_app_info != null) {
        i = paramInt + i.a.a.a.qC(8, this.mini_app_info.computeSize());
      }
      paramInt = i;
      if (this.html5_info != null) {
        paramInt = i + i.a.a.a.qC(9, this.html5_info.computeSize());
      }
      i = paramInt;
      if (this.native_info != null) {
        i = paramInt + i.a.a.a.qC(10, this.native_info.computeSize());
      }
      paramInt = i;
      if (this.schema_info != null) {
        paramInt = i + i.a.a.a.qC(11, this.schema_info.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.source) + i.a.a.b.b.a.cJ(13, this.expired_ts) + i.a.a.b.b.a.cJ(14, this.dislike);
      paramInt = i;
      if (this.icon_url_dark != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.icon_url_dark);
      }
      i = paramInt;
      if (this.icon_url_bg != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.icon_url_bg);
      }
      paramInt = i;
      if (this.red_dot != null) {
        paramInt = i + i.a.a.a.qC(18, this.red_dot.computeSize());
      }
      i = paramInt;
      if (this.jump_id != null) {
        i = paramInt + i.a.a.b.b.a.h(19, this.jump_id);
      }
      paramInt = i.a.a.b.b.a.cJ(20, this.banner_type);
      int j = i.a.a.b.b.a.cJ(21, this.position);
      AppMethodBeat.o(258331);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258331);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      FinderJumpInfo localFinderJumpInfo = (FinderJumpInfo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      case 17: 
      default: 
        AppMethodBeat.o(258331);
        return -1;
      case 1: 
        localFinderJumpInfo.jumpinfo_type = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258331);
        return 0;
      case 2: 
        localFinderJumpInfo.business_type = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258331);
        return 0;
      case 3: 
        localFinderJumpInfo.icon_url = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258331);
        return 0;
      case 4: 
        localFinderJumpInfo.wording = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258331);
        return 0;
      case 5: 
        localFinderJumpInfo.recommend_reason = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258331);
        return 0;
      case 6: 
        localFinderJumpInfo.ext_info = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258331);
        return 0;
      case 7: 
        localFinderJumpInfo.report_info = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258331);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new MiniAppInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((MiniAppInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderJumpInfo.mini_app_info = ((MiniAppInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258331);
        return 0;
      case 9: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new Html5Info();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((Html5Info)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderJumpInfo.html5_info = ((Html5Info)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258331);
        return 0;
      case 10: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new NativeInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((NativeInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderJumpInfo.native_info = ((NativeInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258331);
        return 0;
      case 11: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new SchemaInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((SchemaInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderJumpInfo.schema_info = ((SchemaInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258331);
        return 0;
      case 12: 
        localFinderJumpInfo.source = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258331);
        return 0;
      case 13: 
        localFinderJumpInfo.expired_ts = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258331);
        return 0;
      case 14: 
        localFinderJumpInfo.dislike = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258331);
        return 0;
      case 15: 
        localFinderJumpInfo.icon_url_dark = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258331);
        return 0;
      case 16: 
        localFinderJumpInfo.icon_url_bg = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258331);
        return 0;
      case 18: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderJumpInfoRedDot();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderJumpInfoRedDot)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderJumpInfo.red_dot = ((FinderJumpInfoRedDot)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258331);
        return 0;
      case 19: 
        localFinderJumpInfo.jump_id = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258331);
        return 0;
      case 20: 
        localFinderJumpInfo.banner_type = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258331);
        return 0;
      }
      localFinderJumpInfo.position = ((i.a.a.a.a)localObject1).ajGk.aar();
      AppMethodBeat.o(258331);
      return 0;
    }
    AppMethodBeat.o(258331);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderJumpInfo
 * JD-Core Version:    0.7.0.1
 */