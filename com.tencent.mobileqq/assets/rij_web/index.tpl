<!DOCTYPE html>
<html class="has-bottombar">

<!--头部-->
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Cache-Control" content="no-cache, max-age=0, must-revalidate, no-store" />
	<meta http-equiv="Expires" content="0" />
	<meta name="viewport"
		content="width=device-width,initial-scale=1.0,maximum-scale=2.0,user-scalable=0, viewport-fit=cover" />
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black" />
	<meta name="format-detection" content="telephone=no" />
	<meta itemprop="name" content="{{title}}" />
	<meta itemprop="description" content="{{title}}" />
	<meta itemprop="image"
		content="{{coverImageUrl}}" />
	<title></title>
	<script>
    	var g_timepoint_head = Date.now();
  	</script>
	{{beaconWebScript}}
	{{articleCss}}
	{{articleNewCss}}
</head>

<body id="activity-detail" class="">
	<!-- 网页前置js脚本 -->
    {{prefixScript}}

	<!-- 正文部分 -->
	<div class="ui-refresh-page kandian cleanStyle">
		<!-- 文章主体部分 -->
		<div class="rich_media">
			<div class="rich_media_inner">

				<!-- 文章标题 -->
				<h2 class="rich_media_title" id="activity-name">{{title}}</h2>

				<!-- 公众号头部信息 -->
				<div id="account_top" class="account_top show_profile">
					<img class="puin_avatar" data-src="{{accountAvatarUrl}}"
						src="{{accountAvatarUrl}}" />
					<div class="puin_text">
						<div class="pname">
							{{accountName}}
						</div>
					</div>
					<div class="rich_media_meta_list">
						<em class="rich_media_meta text num">
							{{publishTime}}
						</em>
						<em class="rich_media_meta text reading-count-wrap">阅读
							<span id="reading-count" class="count"><span class="num">{{readCount}}</span></span></em>
					</div>
					<div class="action action_clear" data-attention-type="0">
						<span class="puin_action puin_follow">
							<span class="txt">关注</span>
						</span>
					</div>
				</div>
				<!-- 公众号头部信息 -->

				<!-- 正文内容 -->
				<div id="page-content">
					<div class="">
						<!-- 主体内容 -->
                        <div id="main-content">
							<div class="rich_media_content" id="js_content">
								{{articleContent}}
							</div>

							<!-- 文章话题容器 -->
							<div class="topic-box" id="topic_box"></div>

							<!-- 底部操作栏 -->
							<p class="wrap_btn_original">
							</p>
							<p></p>
						</div>

						<!--看点灰度tag栏-->
						<div class="tag-kd"></div>
						<!--看点话题栏-->
						<div class="topic-kd"></div>
					</div>
					<div class="bottom_watermark"></div>
				</div>
				<!-- 正文内容 -->

			</div>
		</div>

		<!--文章附加内容-->
		<div class="page_extra">
			<div class="article-related-card"></div>

			<!-- 推荐位广告包裹容器 -->
			<div id="wrap_extra" class="wrap_extra"></div>

			<!-- 推荐位卡片 -->
			<div id="recommend" class="recommend"></div>
			<div id="recommend_other" class="recommend"></div>
			<div id="recommend_cards" class="recommend"></div>

			<!-- 广告 -->
			<div id="gdt-ad"></div>

			<!-- 评论区域 -->
			<div class="comments-module">
				<section class="comment-feeds comments-mine">
					<h3 class="title">与我相关</h3>
					<ul class="comments-list">

					</ul>
				</section>
				<section class="comment-feeds comments-all">
					<h3 class="title">全部评论</h3>
					<div class="comment_container">
						<ul class="comments-list">

						</ul>
						<div class="ui-refresh-down"></div>
						<div class="comments-status">
							<p class="no_comment">还没有评论，快来抢沙发吧~</p>
							<p class="comment_error">评论拉取失败</p>
							<p class="comment_get_error">拉取失败，再试一次~</p>
							<p class="more_comment">继续查看更多评论<i></i></p>
							<p class="no_more">已显示所有评论</p>
						</div>
					</div>

				</section>
			</div>
			<section class="comments-hot comment-feeds">
				<h3 class="title">热门评论</h3>
				<ul class="comments-list">
				</ul>
				<div class="comments-status">
					<p class="loading"></p>
					<p class="guide-comments">打开QQ看点查看更多评论<i></i></p>
					<p class="no_comment">还没有评论，快来抢沙发吧~</p>
					<p class="more_comment">继续查看更多评论<i></i></p>
				</div>
			</section>
		</div>

		<!--数据通用模块-->
		<div id="mod-common" data-subscribe-id="" data-public-uin="{{pUin}}" data-mp-name="{{accountName}}"
			 data-mp-desc="" data-article-id="{{articleId}}" data-article-title="{{title}}"
			 data-article-desc=""
			 data-cover-url="{{coverImageUrl}}"
			 data-image-url="{{coverImageUrl}}"
			 data-material-id="0" data-msg-id="0" data-url="" data-short-url="" data-op-type="0x8005899"
			 data-op-name="0x8005899" data-is-media="0" data-mp-type="kandian" data-article-type="kandian"
			 data-account-flag="4" data-article-source="5" data-video-vid="" data-video-resource="" data-video-tag=""
			 data-rowkey="{{rowKey}}" data-original-url="" data-big-image="" data-article-form="article"
			 data-gray-modules="" data-mp-icon="{{accountAvatarUrl}}"
			 data-share-words="随手分享，手有余香|你颜值这么高，看的文章都这么好|世界这么美，就是因为你这样可爱的小喇叭|独乐乐不如众乐乐|知识改变命运，好文分享心情|常常分享的人运气都不会太差"
			 data-atlas-aioimg="" data-atlas-qzoneimg="" data-atlas-count=""
			 data-comment-sig="" data-timestamp=""
			 data-article-sig="" data-ispolitics="0" data-author="{{accountName}}" data-comment-count="0"
			 data-smart-coverimg="{{coverImageUrl}}"
			 data-serial-id="" data-org-uin="" data-serial-index="" data-nimage="" data-fuin="" data-pv="{{readCount}}"
			 data-tags="{{tags}}"
			 data-ftags=""
			 data-bizinfo="{}">
		</div>
	</div>

	<!--评论bar直出-->
	{{commentBarScript}}

	<!-- 底部biu   -->
	<div class="footer_biu footer_biu_hide">
    <span class="pin_btn">
      <i class="pin_fireworks"></i>
    </span>
	</div>
	<script src="https://open.mobile.qq.com/sdk/qqapi.wk.js?_bid=152"></script>

	<!-- debug script -->
	{{debugScript}}
	<script type="text/javascript" src="https://watchspot.cdn-go.cn/article-new/latest/libs/vue.min_new.js"></script>
	<script type="text/javascript" src="https://watchspot.cdn-go.cn/article-new/latest/js/article_new.js"></script>
	<script src="https://s.url.cn/pub/js/alloyreport.js?_bid=2231"></script>

	<!-- sea script -->
	{{seaScript}}
	{{cookieScript}}
	{{longPressScript}}
	<script language="javascript" src="https://pingjs.qq.com/tcss.ping.https.js?_bid=2258"></script>
</body>

</html>